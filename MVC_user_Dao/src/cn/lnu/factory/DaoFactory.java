package cn.lnu.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//��������Dao������������Daoʵ���࣬cn.lnu.dao.impl.UserDaoJdbcImpl.java��cn.lnu.dao.impl.UserDaoXmlImpl.java����ʹ���ĸ�ͨ�������ļ�
//����ģʽһ��Ҫ���ɵ����ģ���ϣ������daoֻ��һ����������
public class DaoFactory {
	
	private Properties daoConfig=new Properties();
	private DaoFactory(){
		InputStream in=DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		//�������ļ�����Ϣload��һ��prop������ȥ
		try {
			daoConfig.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("�������ļ�ʧ�ܣ�");
		}
	}
	
	private static DaoFactory instance=new DaoFactory();
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	//����dao               //UserDao.class
						    //DepartmentDao.class
	public <T> T createDao(Class<T> clazz) {//����Ϊ�ӿ�����,����ʹ�÷��ͣ������㴫�ݽ�������ʲô���͵�T���Ǵ����������͵ģ�Ȼ�󷵻صĻ����㴫�ݽ���������
		//���ݴ������Ľӿڵ����Ƽ���dao.properties�����ļ��ҵ�����ӿڵ�ʵ����
		//1,�õ����ݽ����Ľӿڵ�����
		//clazz.getName();//cn.lnu.dao.UserDao.java
		String name=clazz.getSimpleName();//��ýӿڵļ������������UserDao
		//2,�������ļ��������Ҫʵ�������������
		String className=daoConfig.getProperty(name);
		
		try {
			Class.forName(className);
			T dao=(T) Class.forName(className).newInstance();
			return dao;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
