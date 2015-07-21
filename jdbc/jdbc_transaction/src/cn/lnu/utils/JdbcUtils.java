package cn.lnu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//CustomerDaoImpl����������Ĺ������벿�ֳ�������Ĺ����࣬��Ҫ��ɴ������ļ��ж�ȡ��Ϣ���������ݿ����ӣ��Լ�����ͷ���Դ�Ĺ�������
public class JdbcUtils {
	//�����ⲿ��Ϊ�˲��ٳ�����д�����ҽ������������ݿ�������Ϣд��һ��db.properties����srcĿ¼�´�����������ļ��������ļ���
	/*private static final String url="jdbc:mysql://localhost:3306/jdbc_demo";
	private static final String user="root";
	private static final String password="root";*/
	
	private static Properties config=new Properties();
	//��̬����飬ֻ����һ��mysql��������ȡһ�������ļ�
	static{
		try{
		//�������ļ�db.properties
		config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
		Class.forName(config.getProperty("driver"));
		}catch(Exception e){
			//��һ����ʼ�������쳣
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	//���һ�����ݿ�����
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(config.getProperty("url"),config.getProperty("username"),config.getProperty("password"));
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
