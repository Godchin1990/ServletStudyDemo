package cn.lnu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//���������ר�Ų�������Ĵ���,���ض���ʵҵ�����(����)��ֱ�ӷ���
public class LiyuchunProxy {//�����࣬���ڲ���chunchun����
	private Person chunchun=new Liyuchun();//���ڼ�ס�ǲ���Liyuchun�Ĵ���
	
	//Demo----->Person person=LiyuchunProxy.createProxy();    person.sing();   person.dance()
	public Person createProxy(){
		//newProxyInstance�����ĵڶ���������һ���ӿڣ�����ʹ��chunchun�������Ľӿڴ��������Ĵ�����һ��������һ���������������������ʹ�ñ������������������������������������ָ����������������ʲô����
		//ʵ�ʿ����У�ʹ���������������ĳ������Ĵ�����󣬲���������invoke������ʵ���������
		return (Person) Proxy.newProxyInstance(LiyuchunProxy.class.getClassLoader(), chunchun.getClass().getInterfaces(), new InvocationHandler(){
			
			//������ָ�������Ĵ����ʲô����,�������ʵҵ����������ͬ����Ϊ
			
			/*
			 * proxy���Ѵ�����������ݽ������������person����this���������һ���û�����
			 * method������ǰ���õķ���
			 * args�����÷����Ĳ���
			 * 
			 * �����洴���Ĵ���person��sing����dance����ʵ���϶��ǵ������invoke����,������ز������ݸ�invoke����
			 * */
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String methodname=method.getName();//������洴���Ĵ���person���õķ���
				
				if(methodname.equals("sing")){//���������ڲ����������ʵ�������˶Դ���(��ʵҵ�����)��ֱ�ӷ��ʣ�Ȼ����Ǯ����֪ͨ���糪������
					System.out.println("��һ���������Ȼ���Ӳ����裡");
					//����֮�󣬸��ߴ���ȥ���裬������������󴫵ݽ����������������´�
					return method.invoke(chunchun, args);//����ֵлл���ظ�������÷����Ĵ�����
				}else if(methodname.equals("dance")){
					System.out.println("�������������Ȼ���Ӳ����裡");
					
					return method.invoke(chunchun, args);//����ֵ������
				}else{
					System.out.println("���粻֧��������ܣ�");
				}
				return null;
			}
			
		});
	}
	
}
