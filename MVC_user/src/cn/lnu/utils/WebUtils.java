package cn.lnu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

//��request�е����ݷ�װ��bean��
public class WebUtils {                                        //ResgisterForm.class,��󷵻�RegisterForm
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try{
		//1������Ҫ��װ���ݵ�bean
		T bean=beanClass.newInstance();
		
		//2,����������bean��
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();//username password email ...
			String value=request.getParameter(name);
			//��name��Ӧ��ֵ�����䵽bean�������Ӧ������
			BeanUtils.setProperty(bean,name,value);
		}
		return bean;
	}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	//ע���û�ʱ����Ҫ����������ݵ�beanת��Ϊuser
	public static void copyBean(Object src,Object dest){
		//Ϊ���ܽ����е����ڸ�ʽ���浽user�����е�String ���͵�birthday�����ﻹ��Ҫע��һ������ת����
		ConvertUtils.register(new Converter(){
			public Object convert(Class type,Object value){
				if(value==null){
					return null;
				}
				String str=(String)value;
				if(str.trim().equals("")){
					return null;
				}
				
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
			}, Date.class);
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	//����ȫ��Ψһ��id,128λ
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
}
