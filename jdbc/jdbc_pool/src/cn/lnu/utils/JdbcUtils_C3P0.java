package cn.lnu.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//ʹ��c3p0(spring���ʹ�õķ�ʽ)����Դ�������ݿ����ӳصķ�ʽΪ�û�ά��һ������
public class JdbcUtils_C3P0 {
	private static ComboPooledDataSource ds=null;
	//��̬����飬ֻ����һ��mysql��������ȡһ�������ļ�
	static{
		try {
			ds=new ComboPooledDataSource();//����һ��c3p0���ݿ����ӳأ�����Ĭ�ϴ�c3p0-config.xml�����ļ��ж�ȡ������Ϣ��ʼ��������ݿ����ӳأ�ComboPooledDataSource�ڲ����Զ��������ֽ�c3p0-config.xml����ֲ����л��������Ϣ
			/*//��ʼ��������ݿ����ӳ�
			ds.setDriverClass("com.mysql.jdbc.Driver");//����c3p0ʹ�õ����ݿ�����
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_customer");//�������ӵ����ݿ�url
			ds.setUser("root");
			ds.setPassword("root");
			ds.setMaxPoolSize(30);//�������ݿ����ӳ����30������
			ds.setMinPoolSize(5);//�������ݿ����ӳ���С5������
			ds.setInitialPoolSize(10);//�������ݿ����ӳس�ʼ����10������
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
