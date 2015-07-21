package cn.lnu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.lnu.dao.UserDao;
import cn.lnu.domain.User;
import cn.lnu.exception.DaoException;
import cn.lnu.utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao{
	
	//����û�
	/*public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="insert into users(id,username,password,email,birthday,nickname) values('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getBirthday().toLocaleString()+"','"+user.getNickname()+"')";
			int num=st.executeUpdate(sql);
			if(num<1){
				throw new RuntimeException("ע���û�ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}*/
	
	//ʹ��preparedStatement���и��죬��ֹsqlע��
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into users(id,username,password,email,birthday,nickname) values(?,?,?,?,?,?)";
			st=conn.prepareStatement(sql);//������sql����Ԥ����
			//�滻Ԥ����֮��sql����е�ռλ����
			st.setString(1, user.getId());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.setString(4, user.getEmail());
			st.setDate(5, new java.sql.Date(user.getBirthday().getTime()));//��Ҫ��dateתΪsql.date
			st.setString(6, user.getNickname());
			int num=st.executeUpdate();
			if(num<1){
				throw new RuntimeException("ע���û�ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//�����û�������������û�
	/*public User find(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="select * from users where username='"+username+"' and password='"+password+"'";
			rs=st.executeQuery(sql);
			if(rs.next()){
				User user=new User();
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				return user;
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}*/
	
	
	/*
	 * statement��preparedStatement������
	 * 1��preparedStatement��statement�ĺ���
	 * 2��preparedStatement���Է�ֹsqlע�������
	 * 3��preparedStatement���sql������Ԥ���룬�Լ������ݿ��������ѹ��
	 * */
	
	//��ֹsqlע��ʹ��prepareStatement��һ�����ڵ�½����urlʱ�����������ݱ���˵�û��������룬�ᱻ�˲��ö���ע��sql����ķ�����½ϵͳ��
	//����˵��½���в������û���������ֱ������' or 1=1 or username='������û���û���������Ҳ���Ե���ϵͳ�������������sqlע�������ˣ�ҪԤ����
	//���Բ�����web�㣬У���û���������ǲ���һ��sql������ʱ���ܾ���½�����߸�רҵ�ľ��ǲ���prepareStatement�������û��������ת����Ԥ��sqlע��
	public User find(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from users where username=? and password=?";
			st=conn.prepareStatement(sql);//Ԥ��������sql,�������һִ�У�st�������ʹ�������������sql��䣬��ʱ��sql��䲻�������ģ�����ʹ�õ��ǣ�ռλ�������봫��Ĳ���
			//�滻�ʺ�,���ԶԲ�������ת���ֹsqlע��
			//st.setString(1, "' or 1=1 or username='");//prepareStatementִ���������ʱ���' or 1=1 or username='���sqlע���������ת�壬ת��֮����ȥ������ò�ѯ���Ͳ��᷵���κμ�¼����
			st.setString(1, username);
			st.setString(2, password);
			//֮��st�����ڲ���װ��sql�������������ˣ��Ϳ��Ե��ò�ѯ�����
			//st.executeQuery(sql);//��ʱ�Ͳ�Ҫ�ٴ���sql���������ò�ѯ�����ˣ���Ϊsql����ǲ������ģ���st���Ѿ���װ��������sql���
			rs=st.executeQuery();
			if(rs.next()){
				User user=new User();
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				return user;
			}
			
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//�����û��������û�
	/*public boolean find(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			st=conn.createStatement();
			String sql="select * from users where username='"+username+"'";
			rs=st.executeQuery(sql);
			if(rs.next()){
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}*/
	
	//�����û��������û�,ʹ��PreparedStatement����
	public boolean find(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from users where username=?";
			st=conn.prepareStatement(sql);
			st.setString(1, username);
			rs=st.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
}
