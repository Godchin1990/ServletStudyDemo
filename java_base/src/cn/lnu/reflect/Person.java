package cn.lnu.reflect;

import java.io.InputStream;
import java.util.List;

public class Person {
	//��װ���ݵ��ֶ�
	public String name="mushroom";
	private int password=123;
	private static int age=26;
	
	//���캯��
	public Person(){
		System.out.println("public person");
	}
	
	public Person(String name){
		System.out.println("public person "+name);
	}
	
	public Person(String name,int password){
		System.out.println("public person "+name+":"+ password);
	}
	
	private Person(List list){
		System.out.println("private list");
	}
	
	
	//��ķ���
	public void aa(){
		System.out.println("aa");
	}
	
	public void aa(String name,int password){
		System.out.println(name+":"+password);
	}
	
	public Class[] aa(String name,int[] password){
		
		return new Class[]{String.class};
	}
	
	private void aa(InputStream in){
		System.out.println(in);
	}
	
	public static void aa(int num){
		System.out.println(num);
	}
	
	public static void main(String[] args){//main����
		System.out.println("main����");
	}
}
