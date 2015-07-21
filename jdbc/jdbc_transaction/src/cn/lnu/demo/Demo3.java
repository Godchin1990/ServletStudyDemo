package cn.lnu.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.lnu.utils.JdbcUtils;
//��������������漰�����ּ��������������ظ������������
public class Demo3 {
	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		Savepoint sp=null;//java�д���ع���Ķ���
		try{
			conn=JdbcUtils.getConnection();//mysql Ĭ�ϻ���ǲ����ظ��������ݿ�����
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//�ɱ�����������ĸ��뼶��
			conn.setAutoCommit(false);//ȡ������Ĭ���ύ���ܣ���Ϊ�ֶ��ύ��ʽ������ʼ����
			String sql1="select * from account";
			conn.prepareStatement(sql1).executeQuery();
			
			//��������20��
			Thread.sleep(20*1000);
			
			conn.commit();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
