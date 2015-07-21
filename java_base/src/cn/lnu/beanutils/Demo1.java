package cn.lnu.beanutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

//ʹ��beanUtils��ܲ���bean���������,���Ƚ�beanUtils��������Ŀ��������ɵ�������
//��Ҫ�����������У�commons-beanutils-1.8.0.jar commons_logging.jar����־��¼��jar������commons-beanutils-1.8.0.jar��ܹ�����������jar��ʵ��beanUtils��ܹ����е���־��¼��Ϣ
public class Demo1 {
	
	@Test
	public void test1() throws Exception{
		Person bean=new Person();
		BeanUtils.setProperty(bean, "name", "zhangsan");//��ʾ�����ĸ�bean���ĸ����ԣ���Ϊ������Ը�ֵΪvalue
		
		System.out.println(bean.getName());//zhangsan

	}
	
	//�������δ��������⣬��ֻ�ܽ��ַ���ת��Ϊ���ֻ����������ͣ�����ת���ַ������ǰ��ֻ������͵ĸ������ͣ����������ڣ���ҪΪ��ת����������ע��ת������
	//û��Ϊ��������ע��ת����ʱ�����������:     DateConverter does not support default String to 'Date' conversion.
	@Test
	public void test2() throws Exception{
		String name="aaa";
		String password="123";
		String age="24";
		String birthday="1980-09-09";
		
		Person bean=new Person();
		BeanUtils.setProperty(bean, "name", name);//��ʾ�����ĸ�bean���ĸ����ԣ���Ϊ������Ը�ֵΪvalue
		BeanUtils.setProperty(bean, "password", password);
		BeanUtils.setProperty(bean, "age", age);//ֻ֧���ַ�����8�ֻ������������Զ�ת��
		BeanUtils.setProperty(bean, "birthday", birthday);
		
		System.out.println(bean.getName());//aaa
		System.out.println(bean.getPassword());//123
		System.out.println(bean.getAge());//24�����Կ���ǰ̨���ݹ������ݶ������ַ������͵ģ�����bean����age������int�ͣ�Ҳ����beanUtils���֧�ֽ�ǰ̨���ַ��������Զ�ת��Ϊ���ֻ����������ݣ����Ǹ������ͣ��Ͳ������ˣ���Ҫ����Ϊ��������ע��һ��ת��������beanUtils�����ת����ȥ��ǰ̨string����ת��Ϊbean����ĸ����������ԣ�����������
		System.out.println(bean.getBirthday());//1980-09-09
	}

	//ΪbeanUtils���ע��ʵ�ֽ��ַ���ת��Ϊ�����������͵�ת�����������ǽ����ַ���ת��Ϊ�������ڵ�ת����
	@Test
	public void test3() throws Exception{
		String name="aaa";
		String password="123";
		String age="24";
		String birthday="1980-09-09";
		
		//Ϊ�������ڸ���bean��birthday�����ϣ����Ǹ�beanUtilsע��һ������ת������beanUtilsΪ��ָ����Ϊ��������ע��ת�����ķ���ConvertUtils������
		ConvertUtils.register(new Converter(){//��beanUtilsת��֮ǰע������ת���������͵�ת����

			public Object convert(Class type, Object value) {//���������beanUtils���ã���value�ַ���������ֵת��Ϊ���ӵ�type����(������Date����)
				//���ȼ��ǰ̨���������ַ�������value�Ƿ�Ϊ�գ�Ϊ�ղ�����ת��
				if(value==null){
					return null;
				}
				
				if(!(value instanceof String)){//�ж�beanUtils���ݽ�����ǰ̨Ҫת��Ϊ�������͵������ǲ���String����
					throw new RuntimeException("֧��String���͵�ת��");
				}
				
				String str=(String)value;//��valueת��ΪString����
				if(str.trim().equals("")){//��ֹǰ̨���ݹ������ַ�����һϵ�еĿո���  ��     ��
					return null;
				}
				//˵�����ַ�������ֵ
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);//���ܲ�д���e���쳣�����ܶ�
				}
			}
		}, Date.class);//ΪbeanUtilsע��һ��ʵ�ֽ��ַ���ת��Ϊclazz��ʾ�ĸ������͵�ת����
		
		Person bean=new Person();
		BeanUtils.setProperty(bean, "name", name);//��ʾ�����ĸ�bean���ĸ����ԣ���Ϊ������Ը�ֵΪvalue
		BeanUtils.setProperty(bean, "password", password);//ֻ֧���ַ�����8�ֻ������������Զ�ת��
		BeanUtils.setProperty(bean, "age", age);
		BeanUtils.setProperty(bean, "birthday", birthday);
		
		System.out.println(bean.getName());//aaa
		System.out.println(bean.getPassword());//123
		System.out.println(bean.getAge());//24�����Կ���ǰ̨���ݹ������ݶ������ַ������͵ģ�����bean����age������int�ͣ�Ҳ����beanUtils���֧�ֽ�ǰ̨���ַ��������Զ�ת��Ϊ���ֻ����������ݣ����Ǹ������ͣ��Ͳ������ˣ���Ҫ����Ϊ��������ע��һ��ת��������beanUtils�����ת����ȥ��ǰ̨string����ת��Ϊbean����ĸ����������ԣ�����������
		System.out.println(bean.getBirthday().toLocaleString());//1980-9-9 0:00:00
	}
	
	//ʹ��Apache������ʵ�ֵ�ת�����ڵ�ת������ʵ�ֽ��ַ���ת��Ϊ�������͵���������,�������ת�������������String birthday="";,������bean������ֵ��ֵΪnull.���ǳ�����׳��쳣
	@Test
	public void test4() throws Exception{
		String name="aaa";
		String password="123";
		String age="24";
		String birthday="1980-09-09";
		
		//ʹ��apache���Ѿ�ʵ��Convert�ӿڵ�ת������DateLocaleConverterʵ�ֽ�ǰ�˷��͵��������͵��ַ�������ת��Ϊbean�������Ե�������������
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		Person bean=new Person();
		BeanUtils.setProperty(bean, "name", name);//��ʾ�����ĸ�bean���ĸ����ԣ���Ϊ������Ը�ֵΪvalue
		BeanUtils.setProperty(bean, "password", password);
		BeanUtils.setProperty(bean, "age", age);//ֻ֧���ַ�����8�ֻ������������Զ�ת��
		BeanUtils.setProperty(bean, "birthday", birthday);
		
		System.out.println(bean.getName());//aaa
		System.out.println(bean.getPassword());//123
		System.out.println(bean.getAge());//24�����Կ���ǰ̨���ݹ������ݶ������ַ������͵ģ�����bean����age������int�ͣ�Ҳ����beanUtils���֧�ֽ�ǰ̨���ַ��������Զ�ת��Ϊ���ֻ����������ݣ����Ǹ������ͣ��Ͳ������ˣ���Ҫ����Ϊ��������ע��һ��ת��������beanUtils�����ת����ȥ��ǰ̨string����ת��Ϊbean����ĸ����������ԣ�����������
		System.out.println(bean.getBirthday().toLocaleString());//1980-9-9 0:00:00
	}
	
	@Test
	public void test5() throws Exception{
		Map map=new HashMap();
		map.put("name", "aaa");
		map.put("password", "123");
		map.put("age", "23");
		map.put("birthday", "1980-09-09");
		
		//ʹ��apache���Ѿ�ʵ��Convert�ӿڵ�ת������DateLocaleConverterʵ�ֽ�ǰ�˷��͵��������͵��ַ�������ת��Ϊbean�������Ե�������������
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person bean =new Person();
		BeanUtils.populate(bean, map);//ʹ��map���ϵ�key-valueֵ���bean��������ԣ��ڲ��ǽ�map�ؼ���keyΪname������valueֵ��䵽bean�����Ӧ��name����ֵ�ϣ���map�Ĺؼ������Ʊ�����bean���Ե�����������һ��
		
		System.out.println(bean.getName());//aaa
		System.out.println(bean.getPassword());//123
		System.out.println(bean.getAge());//24�����Կ���ǰ̨���ݹ������ݶ������ַ������͵ģ�����bean����age������int�ͣ�Ҳ����beanUtils���֧�ֽ�ǰ̨���ַ��������Զ�ת��Ϊ���ֻ����������ݣ����Ǹ������ͣ��Ͳ������ˣ���Ҫ����Ϊ��������ע��һ��ת��������beanUtils�����ת����ȥ��ǰ̨string����ת��Ϊbean����ĸ����������ԣ�����������
		System.out.println(bean.getBirthday().toLocaleString());//1980-9-9 0:00:00
	}
}
