package cn.lnu.beanutils;

import java.util.Date;

public class Person {//javabean  �ṩ��get/set�������ֶν������ԣ�ע�������ص�һ��class���ԣ���Ϊ�����඼�̳���Object,�������һ��getClass���������Ի���������һ��Class����
	
	private String name;//�ֶ�
	private int password;
	private int age;
	private Date birthday;
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
