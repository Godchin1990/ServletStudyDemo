package cn.lnu.proxy;

public class Liyuchun implements Person {
	public String sing(String name){
		System.out.println("���糪"+name+"���ˣ�");
		
		return "лл��";
	}
	
	public String dance(String name){
		System.out.println("������"+name+"���ˣ�");
		return "����";
	}
}
