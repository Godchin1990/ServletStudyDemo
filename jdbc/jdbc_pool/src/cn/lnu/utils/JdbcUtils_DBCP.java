package cn.lnu.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
//ʹ��dbcp����Դ�������ݿ����ӳصķ�ʽΪ�û�ά��һ������
public class JdbcUtils_DBCP {
	private static DataSource ds=null;//������һ�����ݿ����ӳأ��û���ס�ӹ������д��������ӳ�
	//��̬����飬ֻ����һ��mysql��������ȡһ�������ļ�
	static{
		try{
			InputStream in=JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");//�������ļ�����һ������
			Properties dbcpconfig=new Properties();
			dbcpconfig.load(in);
			
			BasicDataSourceFactory factory=new BasicDataSourceFactory();//newһ�����ӳع���
			ds=factory.createDataSource(dbcpconfig);//����dbcp�����ļ�����һ�����ݿ����ӳ�
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	//�����ݿ����ӳ�ds�л��һ�����ݿ�����
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			rs=null;
		}
		if(st!=null){
			try{
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			st=null;
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			conn=null;
		}
	}
}
