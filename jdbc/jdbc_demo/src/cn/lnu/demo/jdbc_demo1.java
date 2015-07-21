package cn.lnu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_demo1 {
	/*
	  create database jdbc_demo;
	  use jdbc_demo;
	  
	  create table users(
			id int primary key,
			name varchar(40),
			password varchar(40),
			email varchar(60),
			birthday date
			);

	  insert into users(id,name,password,email,birthday) values(1,'zs','123456','zs@sina.com','1980-12-04');
	  insert into users(id,name,password,email,birthday) values(2,'lisi','123456','lisi@sina.com','1981-12-04');
	  insert into users(id,name,password,email,birthday) values(3,'wangwu','123456','wangwu@sina.com','1981-12-04');
	  */
	public static void main(String[] args) throws SQLException{
		String url="jdbc:mysql://localhost:3306/jdbc_demo";//�̶�д����Э��+����+�˿ں�(ָ���ĸ����ݿ⣬������3306mysqlӦ�ó���)+ʹ�õ����ݿ���
		String username="root";
		String password="root";
		
		//1,����jar����������������������ĿĿ¼�´���һ��libĿ¼����mysql������jar�����Ƶ�libĿ¼�£�Ȼ��jar��Build Path-->add to build path�ӵ�java��classpath����·����ȥ��Ȼ��Ϳ��Լ���������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());//��DriverManagerע�������������
		//2,������ݿ�����ӵ���import java.sql.Connection;��
			Connection conn=DriverManager.getConnection(url, username, password);//��ͼ�������������ݿ�url������
		//3�����������ݿ�֮�󣬴��������ݿⷢ��sql����statement�Ķ���
			Statement st=conn.createStatement();
		//4�������ݿⷢ��sql��䣬��ȡ���ݿⷵ�صĽ����
			ResultSet rs=st.executeQuery("select * from users");
		//5���ӽ�����л������
			System.out.println("----------------ȡ������������---------------------");
			while(rs.next()){//��ʼ��next�����ǽ��α�ӱ�ͷ�ƶ�����һ����¼���ϣ���������м�¼����true,���򷵻�false
				System.out.println("id="+rs.getObject("id"));
				System.out.println("name="+rs.getObject("name"));
				System.out.println("email="+rs.getObject("password"));
				System.out.println("email="+rs.getObject("email"));
				System.out.println("birthday="+rs.getObject("birthday"));
				System.out.println("-------------------------------------");
			}
			
			//ȡָ���е�����
			System.out.println("----------------ȡ�ڶ�������---------------------");
			rs.absolute(2);//���Զ�λ���ڶ��У�ȡ�ڶ�������
			System.out.println("id="+rs.getObject("id"));
			System.out.println("name="+rs.getObject("name"));
			System.out.println("email="+rs.getObject("password"));
			System.out.println("email="+rs.getObject("email"));
			System.out.println("birthday="+rs.getObject("birthday"));
			System.out.println("-------------------------------------");
			
			//ȡ��һ������
			System.out.println("----------------ȡ��һ������---------------------");
			rs.beforeFirst();
			rs.next();
			System.out.println("id="+rs.getObject("id"));
			System.out.println("name="+rs.getObject("name"));
			System.out.println("email="+rs.getObject("password"));
			System.out.println("email="+rs.getObject("email"));
			System.out.println("birthday="+rs.getObject("birthday"));
			System.out.println("-------------------------------------");
			
			//ȡ���һ������
			System.out.println("----------------ȡ���һ������---------------------");
			rs.afterLast();
			rs.previous();
			System.out.println("id="+rs.getObject("id"));
			System.out.println("name="+rs.getObject("name"));
			System.out.println("email="+rs.getObject("password"));
			System.out.println("email="+rs.getObject("email"));
			System.out.println("birthday="+rs.getObject("birthday"));
			System.out.println("-------------------------------------");
		//6���ͷ���Դ����Ҫ�Ƿ�����,�����ӻ������ݿ�
			rs.close();
			st.close();
			conn.close();
	}
}
