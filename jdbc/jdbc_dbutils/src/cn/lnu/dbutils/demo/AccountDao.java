package cn.lnu.dbutils.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.lnu.domain.Account;
import cn.lnu.utils.JdbcUtils;

//ʹ��dbutils��ܽ������ﴦ��
public class AccountDao {
	
	private Connection conn;//��סͨ�����캯�����service�㴦��ҵ���߼����ݽ������ݿ����ӣ��ڲ�������ʱ�����漰��crud������sql���������������ִ��
	public AccountDao() {
		super();
	}
	public AccountDao(Connection conn){
		this.conn=conn;
	}
	public void update(Account a){
		try {
			QueryRunner runner=new QueryRunner();
			String sql="update account set money=? where id=?";
			Object params[]={a.getMoney(),a.getId()};
			runner.update(JdbcUtils.getConnection(),sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Account find(int id){
		try {
			QueryRunner runner=new QueryRunner();
			String sql="select * from account where id=?";
			return (Account) runner.query(JdbcUtils.getConnection(),sql, id, new BeanHandler(Account.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//ģ���a-->b�˻�ת��100Ԫ
	public void transfer() throws SQLException{
		Connection conn=null;
		try{
			
			conn=JdbcUtils.getConnection();
			conn.setAutoCommit(false);//�������Ͽ�������
			
			QueryRunner runner=new QueryRunner();
			String sql1="update account set money=money-100 where name='aaa'";
			runner.update(conn, sql1);//�ѿ�����������Ӵ��ݸ�update��runner�Ὣ����sql������ķ�ʽִ��
			
			String sql2="update account set money=money+100 where name='bbb'";
			runner.update(conn, sql2);//�����ͽ�����sql����ͬһ�����������������ִ����
			
			conn.commit();
		}finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
}
