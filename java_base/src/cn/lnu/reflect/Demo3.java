package cn.lnu.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;

//������ķ���
public class Demo3 {
	
	
	//������ķ���:public void aa(){
	@Test
	public void test1() throws Exception{
		//Person p=new Person();
		Class clazz=Class.forName("cn.lnu.reflect.Person");
		Person p=(Person) clazz.newInstance();
		Method  method=clazz.getMethod("aa", null);
		method.invoke(p,null);//����������󣬵���ʱ��Ҫָ��������������Ķ������ĸ����Լ����������Ҫʲô����
	}
	
	//������ķ���:public void aa(String name,int password){
	@Test
	public void test2() throws Exception{
		//Person p=new Person();
		Class clazz=Class.forName("cn.lnu.reflect.Person");
		Person p=(Person) clazz.newInstance();
		
		Method  method=clazz.getMethod("aa", String.class,int.class);//��Ҫָ��Ҫ���䷽���Ĳ�������
		method.invoke(p,"mushroom",123456);//����������󣬵���ʱ��Ҫָ��������������Ķ������ĸ����Լ����������Ҫʲô����
	}
	
	
	//������ķ���:public Class[] aa(String name,int[] password){
	@Test
	public void test3() throws Exception{
		//Person p=new Person();
		Class clazz=Class.forName("cn.lnu.reflect.Person");
		Person p=(Person) clazz.newInstance();
		
		Method  method=clazz.getMethod("aa", String.class,int[].class);//��Ҫָ��Ҫ���䷽���Ĳ�������
		Class clazz1[]=(Class[]) method.invoke(p,"mushroom",new int[]{1,2,3});//����������󣬵���ʱ��Ҫָ��������������Ķ������ĸ����Լ����������Ҫʲô����
		System.out.println(clazz1[0]);
	}
	
	//������ķ���:private void aa(InputStream in){
	@Test
	public void test4() throws Exception{
		//Person p=new Person();
		Class clazz=Class.forName("cn.lnu.reflect.Person");
		Person p=(Person) clazz.newInstance();
		
		Method  method=clazz.getDeclaredMethod("aa", InputStream.class);//��Ҫָ��Ҫ���䷽���Ĳ������ͣ�˽�з�����Ҫʹ��getDeclaredMethod�������ñ�����˽������
		method.setAccessible(true);
		method.invoke(p,new FileInputStream("c:\\1.txt"));//����������󣬵���ʱ��Ҫָ��������������Ķ������ĸ����Լ����������Ҫʲô����
	}
	
	//������ķ���:public static void aa(int num){
	@Test
	public void test5() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");	
		Method  method=clazz.getMethod("aa", int.class);//��Ҫָ��Ҫ���䷽���Ĳ�������
		method.invoke(null,2);//��̬����������󣬵���ʱ����Ҫָ��������������Ķ������ĸ�����null���У���Ȼ���ݸ���������ԣ���λ���ָ�����������Ҫʲô����
	}
	
	//�������Main����:public static void main(String[] args){
	@Test
	public void test6() throws Exception{
		Class clazz=Class.forName("cn.lnu.reflect.Person");	
		Method  method=clazz.getMethod("main", String[].class);//��Ҫָ��Ҫ���䷽���Ĳ�������
		//method.invoke(null,new Object[]{new String[]{"hello","world"}});//��̬����������󣬵���ʱ����Ҫָ��������������Ķ������ĸ�����null���У���Ȼ���ݸ���������ԣ���λ���ָ�����������Ҫʲô����
		method.invoke(null,(Object)new String[]{"hello","world"});//��̬����������󣬵���ʱ����Ҫָ��������������Ķ������ĸ�����null���У���Ȼ���ݸ���������ԣ���λ���ָ�����������Ҫʲô����
	}
}
