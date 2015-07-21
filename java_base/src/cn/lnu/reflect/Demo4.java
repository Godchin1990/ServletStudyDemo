package cn.lnu.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//��������ֶΣ�Ϊ���װһЩ����
public class Demo4 {
	
	//�����ֶΣ�public String name="mushroom";
	@Test
	public void test1() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Field f=clazz.getField("name");
		//��ȡ�ֶη�װ������ֵ
		Object value=f.get(p);//��ȡָ�������ֶη�װ�����ݣ���Ҫָ����װ����ֶε���Ķ��󣬱����Ǵ��ĸ����������ֶ���ȡ����
		Class type=f.getType();//��ȡ�����ֶε���������
		//System.out.println(type);//class java.lang.String
		if(type.equals(String.class)){
			String svalue=(String) value;
			System.out.println(svalue);
		}
		
		//�����ֶε�ֵ
		f.set(p, "Ģ��");
		System.out.println(p.name);//Ģ��
	}
	
	//�����ֶΣ�private int password;
	@Test
	public void test2() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Field f=clazz.getDeclaredField("password");
		f.setAccessible(true);//����������ֶεķ������ԣ�֮����������������һ�����������������ֶ�
		
		System.out.println(f.get(p));//123
	}
	
	//�����ֶΣ�private static int age=26;
	@Test
	public void test3() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Field f=clazz.getDeclaredField("age");
		f.setAccessible(true);//����������ֶεķ������ԣ�֮����������������һ�����������������ֶ�
		
		System.out.println(f.get(p));//26
	}
}
