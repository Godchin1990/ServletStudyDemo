package cn.lnu.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.lnu.utils.JdbcUtils;

//����jdbc��������
/*
 	create table testbatch
 	(
 		id varchar(40) primary key,
 		name varchar(40)
 	);
 * */
public class Demo3 {
	@Test
	public void test1() throws SQLException{//ʵ��������õ�һ�ַ�ʽ�����Է���ͬ���͵�sql������ִ�ж��ֲ���
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils.getConnection();
			String sql1="insert into testbatch(id,name) values(1,'mushroom')";
			String sql2="update testbatch set name='mogu' where id='1'";
			st=conn.createStatement();//Statement�ڲ�ά����һ��list����
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.executeBatch();//�����ݿⷢ��һ��sql
			st.clearBatch();
			
		}finally{
			JdbcUtils.release(conn, st, rs);
			
		}
	}
	
	@Test
	public void test2() throws SQLException{//jdbc������õڶ��ַ�ʽ��ֻ�ܷ�һ�����͵�sql��ֻ�ʺ��������Ĳ�����������²���
		long starttime=System.currentTimeMillis();
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils.getConnection();
			String sql="insert into testbatch(id,name) values(?,?)";
			st=conn.prepareStatement(sql);
			//�൱����st�м�����ʮ��sql���
			for(int i=1;i<=100;i++){
				st.setString(1, i+"");
				st.setString(2, "mushroom"+i);
				st.addBatch();
				if(i%1000==0){
					st.executeBatch();
					st.clearBatch();
				}
			}
			st.executeBatch();
			st.clearBatch();
		}finally{
			JdbcUtils.release(conn, st, rs);
			
		}	
		long endtime=System.currentTimeMillis();
		System.out.println("�ܹ���ʱ��"+(endtime-starttime)/1000+"��");
	}
	
}
