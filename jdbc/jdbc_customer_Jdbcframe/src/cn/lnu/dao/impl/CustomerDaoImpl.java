package cn.lnu.dao.impl;
//�ǵ����ʵ����д��֮�󣬽�ʵ����ķ����ع���һ���ӿڰ��У����巽������CustomerDaoImpl.java��������Ҽ���ѡ��Refactor-->Extract Interface,��ѡ�⼸������������ӿ������������ΪCustomerDao��Ȼ����CustomerDao.java���Ҽ�,Refactor-->Move,������ӿ��ƶ����ӿڰ�cn.lnu.dao��
import java.util.List;

import cn.lnu.dao.CustomerDao;
import cn.lnu.domain.Customer;
import cn.lnu.domain.QueryResult;
import cn.lnu.exception.DaoException;
import cn.lnu.utils.BeanHandler;
import cn.lnu.utils.BeanListHandler;
import cn.lnu.utils.IntHandler;
import cn.lnu.utils.JdbcUtils;

//�����û�����,�������ݲ���Ҫ�ṩ�Ľӿ�
public class CustomerDaoImpl implements CustomerDao {
	public void add(Customer c){
		try{
			String sql="insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			Object params[]={c.getId(),c.getName(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getPreference(),c.getType(),c.getDescription()};
			JdbcUtils.update(sql, params);
		}catch(Exception e){
			throw new DaoException(e);
		}
	}
	
	public void update(Customer c){
		try{
			String sql="update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
			Object params[]={c.getName(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getPreference(),c.getType(),c.getDescription(),c.getId()};
			JdbcUtils.update(sql, params);
		}catch(Exception e){
			throw new DaoException(e);
		}	
	}
	
	public void delete(String id){
		try{
			String sql = "delete from customer where id=?";
			Object params[]={id};
			JdbcUtils.update(sql, params);
		}catch(Exception e){
			throw new DaoException(e);
		}	
		
	}
	
	public Customer find(String id){//�����û�����id����һ���û�
		try{
			String sql="select * from customer where id=?";
			Object params[]={id};
			return (Customer) JdbcUtils.query(sql, params, new BeanHandler(Customer.class));
		}catch(Exception e){
			throw new DaoException(e);
		}	
		
	}
	
	//ȡ�����ݿ��������û�����󱣴浽һ��list������
	public List<Customer> getAll(){
		try{
			String sql="select * from customer";
			Object params[]={};
			return (List<Customer>) JdbcUtils.query(sql, params, new BeanListHandler(Customer.class));
		}catch(Exception e){
			throw new DaoException(e);
		}	
		
	}
	
	//ʵ�ַ�ҳ,����������������ҳ���ѯ���ݺ�ҳ���С
	public QueryResult pageQuery(int startindex,int pagesize){
		QueryResult qr=new QueryResult();
		
		try{
			String sql="select * from customer limit ?,?";
			Object params[]={startindex,pagesize};
			List list=(List) JdbcUtils.query(sql, params, new BeanListHandler(Customer.class));
			qr.setList(list);
			
			sql="select count(*) from customer";
			params=new Object[]{};
			int totalrecord=(Integer) JdbcUtils.query(sql, params, new IntHandler());
			qr.setTotalrecord(totalrecord);
			return qr;
		}catch(Exception e){
			throw new DaoException(e);
		}	
	}
}
