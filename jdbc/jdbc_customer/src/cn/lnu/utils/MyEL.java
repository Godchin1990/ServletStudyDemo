package cn.lnu.utils;
//ʵ�ִ����ݿ���ȡ����ʾ���ֶι�������ʡ�Ժű�ʾ��������
public class MyEL {//�������Լ���el����֮����WEB-INF�´���һ��lnu.tld�ļ�
	public static String sub(String str){
		if(str.length()>10){
			return str.substring(0, 10)+"...";
		}
		return str;
	}
}
