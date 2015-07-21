package cn.lnu.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.lnu.domain.User;
import cn.lnu.utils.JdbcUtils;

//�������¼���������һЩ�������룬���ｫ���ȡ��һ���������У�λ���´�����cn.lnu.utils����JdbcUtils��
public class jdbc_demo3 {
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	@Test
	//�������ݿ�Ĳ������
	public void insert() throws SQLException{
		try{
		    conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="insert into users(id,name,password,email,birthday) values(4,'mushroom','123456','mogu@163.com','1989-10-24')";
			int num=st.executeUpdate(sql);
			if(num>0){
				System.out.println("����ɹ���");
			}
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	@Test
	//�������ݿ���޸Ĳ���
	public void update() throws SQLException{
		try{
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="update users set name='mogu' where id='4'";
			int num=st.executeUpdate(sql);
			if(num>0){
				System.out.print("�������ݱ�ɹ���");
			}
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	@Test
	//�������ݿ��ɾ������
	public void delete() throws SQLException{
		try{
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="delete from users where id='4'";
			int num=st.executeUpdate(sql);
			if(num>0){
				System.out.print("ɾ�����ݱ����ݳɹ���");
			}
			
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	@Test
	//�������ݿ�Ĳ�ѯ����
	public void find() throws SQLException{
		try{
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="select * from users where id='2'";
			rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.println("id="+rs.getInt("id"));
				System.out.println("name="+rs.getString("name"));
				System.out.println("password="+rs.getString("password"));
				System.out.println("email="+rs.getString("email"));
				System.out.println("birthday="+rs.getDate("birthday"));
				System.out.println("------------------------------");
			}
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	@Test
	//�������ݿ������м�¼
	public void getAll() throws SQLException{
		try{
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="select * from users";
			rs=st.executeQuery(sql);
			
			List list=new ArrayList();//��ȡ�õ�ÿһ����¼���浽һ��bean�����У�Ȼ�����bean�������list��
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				list.add(user);
			}
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
