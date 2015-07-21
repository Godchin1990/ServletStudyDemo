package cn.lnu.enumeration2;

import org.junit.Test;

//��ζ�������󷽷���ö��
enum Grade{ //ʹ��enum�ؼ��ֶ��� ö����,A 100-90 ��  B 89-80 ��  C 79-70 һ��  D 69-60 ��   E 59-0 ������
	A("100-90"){//ö�����A����
		public String localeValue(){
			return "��";
		}
	}
	,B("89-80"){
		public String localeValue(){
			return "��";
		}
	}
	,C("79-70"){
		public String localeValue(){
			return "һ��";
		}
	}
	,D("69-60"){
		public String localeValue(){
			return "��";
		}
	}
	,E("59-0"){
		public String localeValue(){
			return "������";
		}
	}; //Object
	
	private String value;
	private Grade(String value){//ö����Ĺ��췽��������˽�еģ���������ڸ�print�������ε�ʱ����Ϊnew�����ö�ٶ���֮�������ֵ����ʱ���Ͳ���ö������
		this.value=value;
	}
	public String getValue(){
		return this.value;
	}
	
	public abstract String localeValue();//����ö�ٵĳ��󷽷������ö�ٴ��г��󷽷�����ô���ö����ÿ�������ʱ��ͱ���ʵ���������
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
public class Demo2 {
	
	@Test
	public void test(){//ͨ������ö��������޶�print�����Ĳ���ֻ�ܽ������޵ļ�������������A,B,C,D,E
		print(Grade.D);//B
	}
	
	public void print(Grade g){
		String value=g.getValue();
		System.out.println(value+":"+g.localeValue());
	}
	
}
