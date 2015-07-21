package cn.lnu.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.lnu.utils.JdbcUtils;

public class Demo2 {

	/**
	 *ʵ��a�û���bת100Ԫ,����sql�������ݿ�ʹ������Ҫôȫ����Ҫôȫ����
	 		*����ع���*
	 * @throws SQLException 
	 * �������
	 * start transaction ��������
	 * ......
	 * ......
	 * [rollback]
	 * commit �ύ����ֻҪû��commit�����ݿ�ͻ��Զ��ع�sql���������ݿ��Ӱ�죬�ָ�������ִ��ǰ��״̬
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		Savepoint sp=null;//java�д���ع���Ķ���
		try{
			conn=JdbcUtils.getConnection();//��������������Զ��ύ�ģ�Ҫ����������Ҫ��������������������Զ��ύ������������
			
			conn.setAutoCommit(false);//������������ݿ������������Զ��ύ���൱�����ݿ��е�start transaction�����������
			
			String sql1="update account set money=money-1000 where name='aaa'";
			String sql2="update account set money=money+1000 where name='bbb'";
			String sql3="update account set money=money+1000 where name='ccc'";
			
			st=conn.prepareStatement(sql1);
			st.executeUpdate();
			
			sp=conn.setSavepoint();//���ûع���
			
			st=conn.prepareStatement(sql2);
			st.executeUpdate();
			
			int x=1/0;//�쳣
			
			st=conn.prepareStatement(sql3);
			st.executeUpdate();
			
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback(sp);
			conn.commit();//�ֶ��ع���һ��Ҫ��ס�ύ����
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

}
