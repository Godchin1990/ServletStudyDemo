package cn.lnu.dao.impl;
//�ǵ����ʵ����д��֮�󣬽�ʵ����ķ����ع���һ���ӿڰ��У����巽������CustomerDaoImpl.java��������Ҽ���ѡ��Refactor-->Extract Interface,��ѡ�⼸������������ӿ������������ΪCustomerDao��Ȼ����CustomerDao.java���Ҽ�,Refactor-->Move,������ӿ��ƶ����ӿڰ�cn.lnu.dao��
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lnu.dao.CustomerDao;
import cn.lnu.domain.Customer;
import cn.lnu.domain.QueryResult;
import cn.lnu.exception.DaoException;
import cn.lnu.utils.JdbcUtils;

//�����û�����,�������ݲ���Ҫ�ṩ�Ľӿ�
public class CustomerDaoImpl implements CustomerDao {
	public void add(Customer c){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try{
			conn=JdbcUtils.getConnection();
			String sql="insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			st=conn.prepareStatement(sql);
			//������
			st.setString(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getGender());
			st.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			st.setString(5, c.getCellphone());
			st.setString(6, c.getEmail());
			st.setString(7, c.getPreference());
			st.setString(8, c.getType());
			st.setString(9, c.getDescription());
			
			int num=st.executeUpdate();
			if(num>0){
				System.out.println("�������û��ɹ���");
			}	
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public void update(Customer c){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try{
			conn=JdbcUtils.getConnection();
			String sql="update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
			st=conn.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getGender());
			st.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
			st.setString(4, c.getCellphone());
			st.setString(5, c.getEmail());
			st.setString(6, c.getPreference());
			st.setString(7, c.getType());
			st.setString(8, c.getDescription());
			st.setString(9, c.getId());
			
			int num=st.executeUpdate();
			if(num>0){
				System.out.print("�����û��ɹ���");
			}
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public void delete(String id){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "delete from customer where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			int num=st.executeUpdate();
			if(num>0){
				System.out.println("ɾ�����ݳɹ���");
			}
		}catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public Customer find(String id){//�����û�����id����һ���û�
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try{
			conn=JdbcUtils.getConnection();
			String sql="select * from customer where id=?";
			st=conn.prepareStatement(sql);
			st.setString(1, id);
			
			rs=st.executeQuery();
			if(rs.next()){
				Customer c=new Customer();
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setDescription(rs.getString("description"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getString("gender"));
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				
				return c;
			}
			return null;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//ȡ�����ݿ��������û�����󱣴浽һ��list������
	public List<Customer> getAll(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		List<Customer> list=new ArrayList();
		try{
			conn=JdbcUtils.getConnection();
			String sql="select * from customer";
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()){
				Customer c=new Customer();
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setDescription(rs.getString("description"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getString("gender"));
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				list.add(c);
			}
			return list;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//ʵ�ַ�ҳ,����������������ҳ���ѯ���ݺ�ҳ���С
	public QueryResult pageQuery(int startindex,int pagesize){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		QueryResult qr=new QueryResult();
		try{
			conn=JdbcUtils.getConnection();
			String sql="select * from customer limit ?,?";
			st=conn.prepareStatement(sql);
			st.setInt(1, startindex);
			st.setInt(2, pagesize);
			rs=st.executeQuery();
			List<Customer> list=new ArrayList();
			while(rs.next()){
				Customer c=new Customer();
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setDescription(rs.getString("description"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getString("gender"));
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				list.add(c);
			}
			
			qr.setList(list);
			//�����ܼ�¼��
			sql="select count(*) from customer";
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			if(rs.next()){
				qr.setTotalrecord(rs.getInt(1));
			}
			return qr;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
