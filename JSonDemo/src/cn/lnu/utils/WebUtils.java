package cn.lnu.utils;

import java.text.ParseException;
import java.util.Enumeration;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

//��request�е����ݷ�װ��bean��
public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try{
		//����Ҫ��װ���ݵ�bean
		T bean=beanClass.newInstance();
		
		//����������bean��
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
			//��name��Ӧ��ֵ�����䵽bean�������Ӧ������
			BeanUtils.setProperty(bean,name,value);
		}
		return bean;
	}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
