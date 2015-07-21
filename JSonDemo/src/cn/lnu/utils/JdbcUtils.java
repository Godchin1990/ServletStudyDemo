package cn.lnu.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource ds=null;
	static{
		InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("c3p0-config.xml");
		ds=new ComboPooledDataSource();//ʹ��Ĭ�ϵ�c3p0�����ļ�����һ�����ݿ����ӳ�
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
