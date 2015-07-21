package cn.lnu.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.lnu.dbutils.demo.AccountDao;
import cn.lnu.domain.Account;
import cn.lnu.utils.JdbcUtils;

//service�㣬��web���ṩ����ת�˷�����Ҫ����dao��
public class BusinessService {
	//ģ���a-->b�˻�ת��100Ԫ
	public void transfer1(int sourceid,int targetid,float money) throws SQLException{
		Connection conn=null;
		try{
			conn=JdbcUtils.getConnection();
			conn.setAutoCommit(false);//Ϊ�˽�����sql�����Ϊһ�����壬��Ҫ��������
			
			AccountDao dao=new AccountDao(conn);
			
			Account a=dao.find(sourceid);//�ײ�select
			Account b=dao.find(targetid);//�ײ�select
			
			a.setMoney(a.getMoney()-money);
			b.setMoney(b.getMoney()+money);
			//int x=1/0;//���쳣�����ݿ��Զ��ع�����
			dao.update(a);//�ײ�update
			dao.update(b);//�ײ�update
		
		conn.commit();//���������ύ������Ͱ�����sql����һ������ִ����
		}finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	//����TreadLocal�Ľ����û�ת�˵����������ԣ���JdbcUtils�������л�ȡʹ��ThreadLocal��ʼ�����ύ���񣬹ر����ӣ�������ӷ���
	public void transfer2(int sourceid,int targetid,float money) throws SQLException{
		
		try{//��δ���ᱻ���̷߳��ʣ�����û��ϵ������߳�һ�������ͷֱ��Ե�ǰ�߳�Ϊkey����һ�����ӣ����ڶ��߳�֮��key��ͬ���߳�֮��Ҳ�����໥���ţ����԰󶨵����ݿ����ӣ�Ҳ�ض������໥����
			JdbcUtils.startTransaction();//������ִ�к󣬵�ǰ�߳��ϾͰ���һ��������������ݿ�����
			//Ȼ��󶨿����������ӵĵ�ǰ�߳�ִ���������,��ֻҪ���������һ���߳����ܣ�������Щ���ݿ����������һ���󶨵���ǰ�߳��µĿ����������������
			AccountDao dao=new AccountDao();
			Account a=dao.find(sourceid);//�ײ�select���ڲ�������Ӷ��ǰ󶨵���ǰ�߳��¿������������
			Account b=dao.find(targetid);//�ײ�select
			
			a.setMoney(a.getMoney()-money);
			b.setMoney(b.getMoney()+money);
			//int x=1/0;//���쳣�����ݿ��Զ��ع�����
			dao.update(a);//�ײ�update
			dao.update(b);//�ײ�update
			JdbcUtils.commitTransaction();
		}finally{
			JdbcUtils.closeConnection();
		}
		
	}
}
