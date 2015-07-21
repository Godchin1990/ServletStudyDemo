package cn.lnu.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
//ʹ��dbcp����Դ�������ݿ����ӳصķ�ʽΪ�û�ά��һ������
public class JdbcUtils {
	private static DataSource ds=null;//������һ�����ݿ����ӳأ��û���ס�ӹ������д��������ӳ�
	//��̬����飬ֻ����һ��mysql��������ȡһ�������ļ�
	static{
		try{
			InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");//�������ļ�����һ������
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
	
	//�ڹ������г�ȡ��ɾ�Ĳ����Ĺ������룬���Ƕ���ֻ��sql���Ͳ�����ͬ,���ｫ�乫�����ֳ�ȡ��һ��������
	public static void update(String sql,Object params[]) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			st=conn.prepareStatement(sql);
			//ʹ�ô��ݹ����Ĳ���������䴫�ݹ�����sql��䣬ʹ���Ϊһ��������sql���
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			st.executeUpdate();
		}finally{
			release(conn, st, rs);
		}
	}
	//��������ʵ�ֶԲ�ѯ�������������ȡ�Ĳ�ѯ�Ż�
	public static Object query(String sql,Object params[],ResultSetHandler handler) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			st=conn.prepareStatement(sql);
			//ʹ�ô��ݹ����Ĳ���������䴫�ݹ�����sql��䣬ʹ���Ϊһ��������sql���
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			rs=st.executeQuery();
			//��������
			return handler.handler(rs);//ʹ���û����ݹ������Լ�ʵ�ֿ�ܱ�¶�ӿڵĽ����������������������������ǽ�������ϴ���һ��list���ϻ���һ��javabean��
		}finally{
			release(conn, st, rs);
		}
	}
}
//�������߲�֪����δ������������û�֪������������������߶��Ⱪ¶һ���ӿڣ����û�����ʵ�֣������û�����֮��Ľ����
interface ResultSetHandler{
	public Object handler(ResultSet rs);
}

//�������߰������������ȼ���ʵ�ʿ����о���ʹ�õĴ����������ڿ������߲�֪�������������ʲô������߼�����������ʵ�ֽӿڵ�ʱ�򴴽�һ�����캯�������û���Ҫ�����������ʲô������߼�����
class BeanHandler implements ResultSetHandler{//Ԥ��ʵ��һ�������������һ��bean�����е���
	private Class clazz;
	public BeanHandler(Class clazz){
		this.clazz=clazz;//�����û����ݹ������࣬�����ס����������������߸�������࣬���������װ���������Ķ����з���
	}
	public Object handler(ResultSet rs) {
		try {
				if(!rs.next()){//����������û�����ݣ����账��ֱ�ӷ���null
					return null;
				}
				//�����ݣ�������װ�������bean
				Object bean=clazz.newInstance();
				//���ڿ������߲�֪��������ж���ʲô���ݣ������Ҫ�õ������Ԫ������,
				ResultSetMetaData meta=rs.getMetaData();//�õ��������Ԫ���ݣ��Ի�ý��������Ϣ
				int count=meta.getColumnCount();//��ý�������ܵ�����
				for(int i=0;i<count;i++){
					String name=meta.getColumnName(i+1);//��ý����ÿ�е���������������±��1��ʼ��
					Object value=rs.getObject(name);//���ÿ��������Ӧ��ֵ
					
					//ͨ��ÿ��ȡ�õĽ�������������bean�����������Ӧ������
					Field f=bean.getClass().getDeclaredField(name);
					f.setAccessible(true);//����bean�����������ʱ������һ��Ϊ˽�У�����ǿ����Ϊ����ʹ�������Բ�������������
					f.set(bean, value);//���������������Ϊf��ֵ���浽bean�����Ӧ������
				}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
//�������ÿһ����¼�����ȴ���һ��bean�У�Ȼ���ڽ����bean�ӵ�һ��List�����У���ʵ�ֿ������߱�¶��handler�ӿڴ�����
class BeanListHandler implements ResultSetHandler{
	private Class clazz;
	public BeanListHandler(Class clazz){//����Ҫ�������ÿһ�м�¼��װ���ĸ���Ķ����е�������������û�ʹ�������������ʱ�򣬾Ͳ���Ҫ����ǰ������new��һ�������ڴ��ݹ���������ֱ�Ӵ��ݹ���һ����
		this.clazz=clazz;
	}
	public Object handler(ResultSet rs) {
		List list=new ArrayList();
		try {
			while(rs.next()){
				Object bean=clazz.newInstance();//ÿȡ��һ����¼��new��һ�������bean����
				ResultSetMetaData meta=rs.getMetaData();
				int count=meta.getColumnCount();
				for(int i=0;i<count;i++){
					String name=meta.getColumnName(i+1);//ÿ��ȡ�������ÿһ�е�����
					Object value=rs.getObject(name);
					
					//���䣬ͨ��ÿ��ȡ�������������bean�����϶�Ӧ������
					Field f=bean.getClass().getDeclaredField(name);
					f.setAccessible(true);//ǿ�����ø�����Ϊ���з������ԣ��򿪸����Եķ���Ȩ�ޣ�����������Ͽ��Ա���ֵ
					f.set(bean, value);//�������ÿ�е�ֵ��ֵ��bean�����Ӧ������	
				}
				list.add(bean);//��ÿ�η������bean��ӵ�һ��list������
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}