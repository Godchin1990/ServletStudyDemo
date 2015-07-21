package cn.lnu.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//�������߰������������ȼ���ʵ�ʿ����о���ʹ�õĴ����������ڿ������߲�֪�������������ʲô������߼�����������ʵ�ֽӿڵ�ʱ�򴴽�һ�����캯�������û���Ҫ�����������ʲô������߼�����
public class BeanHandler implements ResultSetHandler{//Ԥ��ʵ��һ�������������һ��bean�����е���
	private Class clazz;
	public BeanHandler(Class clazz){
		this.clazz=clazz;//�����û����ݹ������࣬�����ס����������������߸�������࣬���������װ���������Ķ����з���
	}
	public Object handler(ResultSet rs) {
		try {
				if(!rs.next()){//����������û�����ݣ����账��ֱ�ӷ���null
					return null;
				}
				//�����ݣ�������װ�������bean
				Object bean=clazz.newInstance();
				//���ڿ������߲�֪��������ж���ʲô���ݣ������Ҫ�õ������Ԫ������,
				ResultSetMetaData meta=rs.getMetaData();//�õ��������Ԫ���ݣ��Ի�ý��������Ϣ
				int count=meta.getColumnCount();//��ý�������ܵ�����
				for(int i=0;i<count;i++){
					String name=meta.getColumnName(i+1);//��ý����ÿ�е���������������±��1��ʼ��
					Object value=rs.getObject(name);//���ÿ��������Ӧ��ֵ
					
					//ͨ��ÿ��ȡ�õĽ�������������bean�����������Ӧ������
					Field f=bean.getClass().getDeclaredField(name);
					f.setAccessible(true);//����bean�����������ʱ������һ��Ϊ˽�У�����ǿ����Ϊ����ʹ�������Բ�������������
					f.set(bean, value);//���������������Ϊf��ֵ���浽bean�����Ӧ������
				}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}