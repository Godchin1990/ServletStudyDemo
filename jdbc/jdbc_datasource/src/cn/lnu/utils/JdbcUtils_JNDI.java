package cn.lnu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtils_JNDI {
	private static DataSource ds=null;
	static{
		try{
			Context initCtx = new InitialContext();//��ʼ��jndi
			Context envCtx = (Context) initCtx.lookup("java:comp/env");//���ҵ�jndi����
			ds = (DataSource) envCtx.lookup("jdbc/EmployeeDB");//�������в��ҵ��󶨵�ָ��jndiԴ�ϵ����ݿ����ӳز�����
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}