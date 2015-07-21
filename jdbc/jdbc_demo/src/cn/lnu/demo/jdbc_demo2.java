package cn.lnu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.lnu.domain.User;

public class jdbc_demo2 {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		String url="jdbc:mysql://localhost:3306/jdbc_demo";//�̶�д����Э��+����+�˿ں�(ָ���ĸ����ݿ⣬������3306mysqlӦ�ó���)+ʹ�õ����ݿ���
		String username="root";
		String password="root";
		
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try{
		//1,DriverManager.registerDriver(new com.mysql.jdbc.Driver());������������ʹ�ã���ᵼ��mysql�����ᱻ��������
			Class.forName("com.mysql.jdbc.Driver");//ʹ�����ַ����������mysql�������������Σ�����ֻ��Ҫ֪��һ�������ַ������Ϳ��Ա�֤������ֻ����һ��
		//2,������ݿ�����ӵ���import java.sql.Connection;��
			conn=DriverManager.getConnection(url, username, password);//��ͼ�������������ݿ�url������
		//3�����������ݿ�֮�󣬴��������ݿⷢ��sql����statement�Ķ���
			st=conn.createStatement();
		//4�������ݿⷢ��sql��䣬��ȡ���ݿⷵ�صĽ����
			rs=st.executeQuery("select * from users");
		//5���ӽ�����л������
			while(rs.next()){//��ʼ��next�����ǽ��α�ӱ�ͷ�ƶ�����һ����¼���ϣ���������м�¼����true,���򷵻�false
				//�������ݿ��л�����ݷ�װ��һ��bean��
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				
				System.out.println("id="+rs.getObject("id"));
				System.out.println("name="+rs.getObject("name"));
				System.out.println("email="+rs.getObject("password"));
				System.out.println("email="+rs.getObject("email"));
				System.out.println("birthday="+rs.getObject("birthday"));
				System.out.println("-------------------------------------");
			}	
		}finally{
		//6���ͷ���Դ����Ҫ�Ƿ�����,�����ӻ������ݿ�
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
	}
}
