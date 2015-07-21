package cn.lnu.factory;

import java.io.InputStream;
import java.util.Properties;

//ʹ�ù�������ȫ����service����dao��֮�����ϵ������Ҫ�ѹ������ɵ�����
public class DaoFactory {
	private static Properties daoconfig=new Properties();//��dao�������ļ���Ϣ���ص�prop����
	static{
		try{
			InputStream in=DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			daoconfig.load(in);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	private DaoFactory(){}
	private static DaoFactory instance=new DaoFactory();
	public static final DaoFactory getInstance(){
		return instance;
	}
	
	//�ṩһ����������dao
	public static <T> T createDao(Class<T> interfaceClass){
		String name=interfaceClass.getSimpleName();//�������ӿڵļ����ƣ��������UpfileDao
		//�������ļ��������ӿڵ�ʵ��ʵ������,������Ҫ����dao��ʵ������
		String daoClassName=daoconfig.getProperty(name);//cn.lnu.dao.impl.UpfileDaoImpl
		//�õ��ӿ�ʵ�����ʵ��������ͨ�����似����������࣬����һ�����ʵ�����ʵ��
		try {
			return (T) Class.forName(daoClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
