package cn.lnu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

//���ڴ����û����룬ʹ���Ⱦ���MD5����ܺ��ٱ��浽���ݿ�
public class ServiceUtils {
	//���ݹ���һ����Ϣ������һ������Ϣ��ժҪ
	public static String md5(String message){
		//Ҫ����md5�룬�������ķ������һ�����Դ���md5�㷨��digest
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte md5[]=md.digest(message.getBytes());//��������Ϣ��ժҪ��Ȼ�󷵻�һ��ժҪ����
			//����ֱ�ӽ�������ĵ�ժҪ���أ�������ʹ��BASE64����ת��Ϊ����֮���ٷ���
			BASE64Encoder encoder=new BASE64Encoder();//�Ȼ��һ������ִ��BASE64�㷨�Ķ���֮�����encode���������ı��������
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
