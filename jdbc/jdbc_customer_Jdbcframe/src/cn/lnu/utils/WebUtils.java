package cn.lnu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	//��request�����ݷ�װ��һ��bean��
	public static <T> T requestToBean(HttpServletRequest request,Class<T> beanClass){
		try {
			T bean = beanClass.newInstance();
			//�õ�request�����������ݣ����浽һ��map������
			Map map=request.getParameterMap();
			//����map{name=aa,password=123,birthday=1990-09-09}-->bean{name=aa,password=123,birthday=Date}���ղ���8�ֻ������ͣ�������Ҫע��һ������ת����
			ConvertUtils.register(new Converter(){
				public Object convert(Class type, Object value) {//type��ʾת��ʲô���ͣ�value��ʾ���ĸ�ֵת��Date
					if(value==null){
						return null;
					}
					//��Ϊ�գ�ǿתΪһ��String
					String str=(String) value;
					//תΪ�ַ���֮�����ж�һ���ַ����Ƿ�Ϊ��
					if(str.trim().equals("")){
						return null;
					}
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					try {
						return df.parse(str);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}	
				}
				
			}, Date.class);
			//ʹ��BeanUtils����䷽����map���Լ����е����ݣ���䵽bean������
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
}
