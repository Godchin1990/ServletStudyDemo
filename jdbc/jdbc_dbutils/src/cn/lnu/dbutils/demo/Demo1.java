package cn.lnu.dbutils.demo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.lnu.domain.User;
import cn.lnu.utils.JdbcUtils;
//ʵ��ʹ��dbutils��Դ��ܶ����ݿ����crud�����Լ����������
public class Demo1 {
	/*
	 create database jdbc_dbutils;
	 use jdbc_dbutils;
	 create table users(
			id int primary key,
			name varchar(40),
			password varchar(40),
			email varchar(100),
			birthday date
			);
insert into users(id,name,password,email,birthday) values(1,'zs','123456','zx@sina.com','1980-10-15');
insert into users(id,name,password,email,birthday) values(2,'lisi','123456','lisi@sina.com','1980-10-15');
insert into users(id,name,password,email,birthday) values(3,'wangwu','123456','wangwu@sina.com','1980-10-15');		
	 * */
	
	//ʹ��dbutils������ݿ��crud����
	@Test
	public void insert() throws SQLException{
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
		Object params[]={4,"mushroom","123","mogu@163.com",new Date()};
		runner.update(sql, params);
	}
	
	@Test
	public void update() throws SQLException{
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="update users set email=? where id=?";
		Object params[]={"mushroom@163.com",4};
		runner.update(sql, params);
	}
	
	@Test
	public void delete() throws SQLException{
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="delete from users where id=?";
		runner.update(sql, 1);
	}
	
	@Test
	public void find() throws SQLException{
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="select * from users where id=?";
		User user=(User) runner.query(sql, 2, new BeanHandler(User.class));
		System.out.println(user.getEmail());
	}
	
	@Test
	public void getAll() throws SQLException{
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());//ͨ������һ�����ݿ����ӳأ�����һ��dbutils�������Ӳ��������ֶ��ͷţ�dbutils��ܻ�������ͷ�
		String sql="select * from users";
		List list=(List) runner.query(sql, new BeanListHandler(User.class));
		System.out.println(list);
	}
	
	@Test
	public void batch() throws SQLException{//����ʹ��dbutils��Դ���ִ��������
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
		Object params[][]=new Object[3][5];
		for(int i=0;i<params.length;i++){//�൱�ڸ�����sql���������
			params[i]=new Object[]{i+1,"aa"+i,"123",i+"@sina.com",new Date()};
		}
		
		runner.batch(sql, params);
	}
}
