package cn.lnu.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

//ʹ����ʡapi����bean������
public class Demo1 {
	
	//�õ�bean����������  ֮���ѧϰbeanutils��ܲ���bean��������ԣ����׿�ܿ���ʹ�����Ƿ���Ĳ���javabean�����ԣ�ʵ�ʿ�������ʹ��beanutils���
	@Test
	public void test1() throws Exception{
		BeanInfo beanInfo=Introspector.getBeanInfo(Person.class,Object.class);//���ָ��javabean��Ϣ��BeanInfo����,����ȥ����Object�̳�����class���ԣ��õ�bean�Լ�������
		PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();//����beanInfo������bean�������Ե�����������
		for(PropertyDescriptor pd:pds){//����ÿ������������
			System.out.println(pd.getName());//age name  password//���Կ���ÿ���������������ص�������
		}
	}
	
	//����bean��ָ�����ԣ�age
	@Test
	public void test2() throws Exception{
		Person p=new Person();
		PropertyDescriptor pd=new PropertyDescriptor("age",Person.class);//����ͨ��new�ķ���ָ�����ָ��bean��ָ�����Ե�����������
		//System.out.println(pd.getName());  //age
		//�õ����Ե�д������Ϊ���Ը�ֵ
		Method method=pd.getWriteMethod();
		method.invoke(p, 28);
		
		//������Ե�ֵ
		method=pd.getReadMethod();
		System.out.println(method.invoke(p, null));//28
	}
	
	//�߼�������ݣ���ȡ��ǰ���������Ե�����
	@Test
	public void test3() throws Exception{
		Person p=new Person();
		PropertyDescriptor pd=new PropertyDescriptor("age",Person.class);//����ͨ��new�ķ���ָ�����ָ��bean��ָ�����Ե�����������
		Class type=pd.getPropertyType();//���ָ����������
		System.out.println(type);//int
	}
	
	
}
