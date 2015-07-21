package cn.lnu.utils;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import cn.lnu.utils.JdbcUtils_DBCP;
//дһ�����ݿ����ӳأ����������ÿ�������������ݿ�Ҫһ�����ݿ����ӣ�Ȼ��ʹ��һ�������������������ݿ�����
public class JdbcPool implements DataSource {
	
	private static LinkedList<Connection> list=new LinkedList();//�������ݿ����ӳ��漰����������ɾ�Ĳ����������ʹ��LinkedList����ṹ�ļ�����ά�����ݿ�����
	
	private static Properties config=new Properties();
	//��̬����飬ֻ����һ��mysql��������ȡһ�������ļ�
	static{//ʹ�þ�̬�����ֻ�ڳ������ʼ��������ʱ�������ݿ�Ҫһ�����ݿ�����
		try{
		//�������ļ�db.properties
		config.load(JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("db.properties"));
		Class.forName(config.getProperty("driver"));//�������ݿ�����
		for(int i=0;i<10;i++){
			Connection conn=DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
			list.add(conn);
		}
		}catch(Exception e){
			//��һ����ʼ�������쳣
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/*//����conn.close();����Ĭ���ǽ����ݿ����ӻ������ݿ���������ӳأ������˵��Connection������close�����Ĺ������㲻�������ˣ���Ҫ��ǿ
	 * ��ʵ�ʿ�����,���ֶ���ķ������㲻�˿�������ʱ�������ַ�ʽ������ǿ��
	 * 1.дһ��connection���࣬����close��������ǿclose����
	 * 2.�ð�װ���ģʽ�����ַ�ʽҲ�ȽϺã�
	 * 3.ʹ�ö�̬����(�ռ������ʽ)  aop����������
	 * */
	public  Connection getConnection() throws SQLException {//ʹ��������������ݿ����ӳ���������
		// TODO Auto-generated method stub
		if(list.size()<=0){//��ʾ���ݿ����ӳ���û��������
			throw new RuntimeException("���ݿ���æ,���Ժ�������");
		}
		Connection conn=list.removeFirst();//������ӳ��������ӣ���ʼ�մ����ӳ����ó���һ�����ӣ�Ȼ��ɾ��������
		
		MyConnection myconn=new MyConnection(conn);
		return myconn;
	}

	//������ð�װ���ģʽ��ǿconn����һ�㲽�����£�
	//1.����һ���࣬ʵ���뱻��ǿ������ͬ�Ľӿ�
	//2.�����ж���һ����������ס����ǿ����
	//3.����һ�����캯�������ܱ���ǿ����
	//4.��������ǿ�ķ���
	//5.���ڲ�����ǿ�ķ�����ֱ�ӵ���Ŀ�����(����ǿ����)�ķ���
	class MyConnection implements Connection{
		
		private Connection conn;

		public MyConnection(Connection conn){
			this.conn=conn;
		}

		public void close() throws SQLException {//����ʹ����֮�󣬻������ӳأ����������ݿ�
			// TODO Auto-generated method stub
			list.add(this.conn);
		}

		public void clearWarnings() throws SQLException {
			// TODO Auto-generated method stub
			this.clearWarnings();
		}

		public void commit() throws SQLException {
			// TODO Auto-generated method stub
			this.commit();
		}

		public Statement createStatement() throws SQLException {
			// TODO Auto-generated method stub
			return this.createStatement();
		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean getAutoCommit() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public String getCatalog() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public int getHoldability() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		public DatabaseMetaData getMetaData() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public int getTransactionIsolation() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		public Map<String, Class<?>> getTypeMap() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public SQLWarning getWarnings() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isClosed() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isReadOnly() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public String nativeSQL(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public CallableStatement prepareCall(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public PreparedStatement prepareStatement(String sql,
				int autoGeneratedKeys) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public PreparedStatement prepareStatement(String sql,
				int[] columnIndexes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public PreparedStatement prepareStatement(String sql,
				String[] columnNames) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public PreparedStatement prepareStatement(String sql)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public void rollback() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public void rollback(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public void setAutoCommit(boolean autoCommit) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public void setCatalog(String catalog) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public void setHoldability(int holdability) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public void setReadOnly(boolean readOnly) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public Savepoint setSavepoint() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public Savepoint setSavepoint(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public void setTransactionIsolation(int level) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		
	}
	public Connection getConnection(String arg0, String arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

}
