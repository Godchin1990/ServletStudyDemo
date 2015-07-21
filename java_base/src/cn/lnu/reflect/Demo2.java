package cn.lnu.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//������Ĺ��캯����������Ķ���
public class Demo2 {

	/**
	 * ������Ĺ��캯����������
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	//���乹�캯����public Person(){
	@Test
	public void test1() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");//����Person���ֽ��뵽�ڴ棬����һ���ֽ������
		Constructor c=clazz.getConstructor(null);//�����������һ���ɱ��������������Ҫ�����޲ι��캯�������ﴫ��null������һ�������޲ι��캯���Ķ���
		
		Person p=(Person) c.newInstance(null);//ͨ��һ�����캯������ķ�������person��Ķ���
		System.out.println(p.name);
	}
	
	//���乹�캯����public Person(String name){
	@Test
	public void test2() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");//����Person���ֽ��뵽�ڴ棬����һ���ֽ������
		Constructor c=clazz.getConstructor(String.class);//�����������һ���ɱ��������������Ҫ��������һ��String���Ͳ����Ĺ��캯�������ﴫ��String.class
		
		Person p=(Person) c.newInstance("mogu");//ͨ��һ�����캯������ķ�������person��Ķ���
		System.out.println(p.name);
	}
	
	//���乹�캯����public Person(String name,int password){
	@Test
	public void test3() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");//����Person���ֽ��뵽�ڴ棬����һ���ֽ������
		Constructor c=clazz.getConstructor(String.class,int.class);//�����������һ���ɱ��������������Ҫ��������һ��String���Ͳ�����һ�����εĹ��캯�������ﴫ��String.class��int.class
		
		Person p=(Person) c.newInstance("mogu",123);//ͨ��һ�����캯������ķ�������person��Ķ���
		System.out.println(p.name);
	}
	
	//���乹�캯����private Person(List list){
	@Test
	public void test4() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");//����Person���ֽ��뵽�ڴ棬����һ���ֽ������
		Constructor c=clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);//���ܹ��캯����ʲô�������ԣ��������򿪳�public�����б�������
		
		List list=new ArrayList();
		Person p=(Person) c.newInstance(list);//ͨ��һ�����캯������ķ�������person��Ķ���
		System.out.println(p.name);
	}
	
	//�������������һ��;��
	@Test
	public void test5() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");//����Person���ֽ��뵽�ڴ棬����һ���ֽ������
		Person p=(Person) clazz.newInstance();//�ڲ��Ƿ���person����޲ι��캯����ʹ�����ַ�ʽ��������������ṩһ���޲ι��캯�����ȼ��������test1�����ȷ�����޲ι��캯����ȥ��������ķ���
		System.out.println(p.name);
	}
}
