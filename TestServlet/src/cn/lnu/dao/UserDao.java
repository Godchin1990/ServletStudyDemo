package cn.lnu.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//�����ȡ��Դ�ļ��ĳ�����servlet�Ļ�����ֻ��ͨ����װ����ȥ����,��ô�ή�ͳ���֮�����϶�
public class UserDao {
	private static Properties dbconfig=new Properties();
	//�����û���update find delete����Ҫ�ڲ������ݿ�ʱ������Ҫ�����������ݿ⣬����������þ�̬�������������
	static{
		try{
		//���ȵõ����װ����
		InputStream in=UserDao.class.getClassLoader().getResourceAsStream("db.properties");
		dbconfig.load(in);
		}catch(Exception e){
			//������ݿⶼ���ʲ��ˣ�����һ���׳������쳣����ֹ��������
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public void update()throws IOException{
		//��ô�ڴ˴�Ϊ�˲������ݿ������ļ�������ô��
		System.out.println(dbconfig.getProperty("url"));
		//���url�����ַ���֮�󣬾Ϳ��Ը�����Ҫ�������ݿ⣬����������ݿ���
		
		}
	
	public void find()throws IOException{
		/*
		//���´�����Ȼ���Զ�ȡ��Դ�ļ������ݣ������޷���ȡ�����ļ��ڷ������ϸ���֮�������
		Properties prop=new Properties();
		InputStream in=UserDao.class.getClassLoader().getResourceAsStream("db.properties");
		prop.load(in);
		System.out.println(prop.getProperty("url"));
		
		*/
		/*��������ֲ�����װ�����ķ�ʽ��������ļ��ķ����������ܶ�ȡ���������ϸ���֮��������ļ���Ϣ�����ң������ļ�����̫�󣬷������ڴ����Σ��
		 	û�޸ķ������е�classes/db.properties�����ļ�ǰ�����jdbc:mysql://localhost:3306/test
			�޸��˷������е�classes/db.properties�����ļ�ǰ�����jdbc:mysql://localhost:3306/test
		 */
		
		//Ҫ���÷������ϸ���֮��������ļ���Ϣ��Ҫ��������ķ�������Ҫʹ����װ����������ʹ�ô�ͳ���ķ�ʽ
		//���Ȼ�������ļ��ľ���·��
		String path=UserDao.class.getClassLoader().getResource("db.properties").getPath();
		FileInputStream in=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(in);
		System.out.println(prop.getProperty("url"));
		/*
		 	û�޸ķ������е�classes/db.properties�����ļ�ǰ�����jdbc:mysql://localhost:3306/test
			�޸��˷������е�classes/db.properties�����ļ�ǰ�����jdbc:mysql://localhost:3306/test1234
		 */
	}
	
	public void delete(){
		
	}
}
