package cn.lnu.string.demo;

public class StringBufferDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer buf1=new StringBuffer("hello");
		StringBuffer buf2=new StringBuffer("java");
		 test(buf1,buf2);
		 System.out.println(buf1+"-----"+buf2);//hello-----javahello��Ҫ����String��StringBuffer֮������𣬽��StringDemo1�Ƚ�
	}
	
	public static void test(StringBuffer s1,StringBuffer s2){
		s2.append(s1);
		s1=s2;
		System.out.println(s1+"-----"+s2);//javahello-----javahello
	}
}
