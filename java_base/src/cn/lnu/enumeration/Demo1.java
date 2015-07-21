package cn.lnu.enumeration;

import org.junit.Test;

import cn.lnu.enumeration.Grade;

//��ζ���ö�ٵĹ��캯�����������ֶΣ�ȥ��װ�������Ϣ
enum Grade{ //ʹ��enum�ؼ��ֶ��� ö����,A 100-90 B 89-80 C 79-70 D 69-60 E 59-0 //���ڶ��弸��ö��ֵ(Grade���͵�)
	A("100-90"),B("89-80"),C("79-70"),D("69-60"),E("59-0"); //Object 
	
	private String value;
	private Grade(String value){//ö����Ĺ��췽��������˽�е�
		this.value=value;
	}
	public String getValue(){
		return this.value;
	}
}

//�ȼ���������Ķ���
/*class Grade{
	private Grade(){
		
	}
	
	public static final Grade A=new Grade();
	public static final Grade B=new Grade();
	public static final Grade C=new Grade();
	public static final Grade D=new Grade();
	public static final Grade E=new Grade();
}*/
public class Demo1 {
	
	@Test
	public void test(){//ͨ������ö��������޶�print�����Ĳ���ֻ�ܽ������޵ļ�������������A,B,C,D,E
		print(Grade.D);//B
	}
	
	public void print(Grade g){
		String value=g.getValue();
		System.out.println(value);
	}
	
	
	//����ö�ٵĳ��÷���
	@Test
	public void test2(){
		System.out.println(Grade.C.name());//C
		System.out.println(Grade.C.ordinal());//2 ����ö������D����������λ��(˳��)
		
		String str="B";
		//Grade g=Grade.valueOf(Grade.class, str);//B ��һ���ַ���תΪһ��ö��ֵ
		Grade g=Grade.valueOf(str);//B
		System.out.println(g);
	
		System.out.println("---------------------");
		Grade gs[]=Grade.values();//����ö������ö�ٶ����һ�����飬����֪�����ö�������м���ö��ֵ
		for(Grade g1:gs){
			System.out.println(g1);
		}
	}
}
