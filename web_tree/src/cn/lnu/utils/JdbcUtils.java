package cn.lnu.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

//�����࣬ʹ��dbcp����ʹ��dbutils���ʱ��Ҫ���ݿ����ӳأ�����Ҳ������дrelesse�����ˣ���Ϊdbutils��Դ��ܻ��Զ�Ϊ�����ͷ�����
public class JdbcUtils {
	private static DataSource ds=null;
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();//ThreadLocal�ڲ�ά������һ��map���ϣ��Ե�ǰ�߳�threadΪkey,set�����󶨵�ֵΪvalue
	static{
		try{
			Properties dbcpconfig=new Properties();
			InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			dbcpconfig.load(in);
			BasicDataSourceFactory factory=new BasicDataSourceFactory();
			ds=factory.createDataSource(dbcpconfig);
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	
	public static Connection getConnection() throws SQLException{//�������ܱ�֤��õ�����ʼ���ǰ󶨵���ǰ�߳��ϵ�������
		try{
			//�õ���ǰ�߳��ϰ�����
			Connection conn=tl.get();
			if(conn==null){//�����߳��ǵ�һ���������߳���û�а�����
				conn=ds.getConnection();//�����ݿ����ӳػ�ȡһ������
				tl.set(conn);//�����Ӱ󶨵���ǰ�߳�
			}
			return conn;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	//ʹ��ThreadLocal��������
	public static void startTransaction(){
		try{
			//�õ���ǰ�߳��ϰ�����
			Connection conn=tl.get();
			if(conn==null){//�����߳��ǵ�һ���������߳���û�а�����
				conn=ds.getConnection();//�����ݿ����ӳػ�ȡһ������
				tl.set(conn);//�����Ӱ󶨵���ǰ�߳�
			}
			conn.setAutoCommit(false);//���󶨵���ǰ�߳��ϵ����ӿ�������
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	//ʹ��TreadLocal�ύ����
	public static void commitTransaction(){
		try{
			//�õ���ǰ�̰߳󶨵�����
			Connection conn=tl.get();
			if(conn!=null){
				conn.commit();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static void closeConnection(){
		try{
			//�õ���ǰ�̰߳󶨵�����
			Connection conn=tl.get();
			if(conn!=null){
				conn.close();//�ر����ӣ������ӻ������ӳ�
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			tl.remove();//ǧ��ע�⣬�����ǰ�߳��ϰ󶨵�����(��ThreadLocal�������Ƴ���Ӧ��ǰ�̵߳�����)�����remove���Ե�ǰ�߳�Ϊkey,�Ƴ����󶨵�����߳��ϵ�����
		}
	}
	
}
