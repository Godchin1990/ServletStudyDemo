package cn.lnu.pool.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.lnu.utils.JdbcUtils_C3P0;
import cn.lnu.utils.JdbcUtils_DBCP;

public class Demo2 {

	/**
	 ����ʹ��C3P0����Դ�������ݿ����ӳ�Ϊ�û�ά��һ�����ӹ�������ķ�ʽ
	 ����ʹ�ö�̬����ķ�ʽ�����ݿ������ڵ���close����ʱ���黹���Ӹ����ݿ����ӳض��������ݿ�
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils_C3P0.getConnection();//�ײ��Ǵ�c3p0���ݿ����ӳ���Ҫ������
			System.out.println(conn);//��ӡ��������ݿ����ӣ�˵�������ݿ����ӳ��гɹ����������
			System.out.println(conn.getClass().getName());//�������connection����Ķ�̬������
		}finally{
			JdbcUtils_C3P0.release(conn, st, rs);
		}
	}

}
