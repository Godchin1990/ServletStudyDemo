package cn.lnu.eclipse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo3 {

	/**
	 * java�Զ�װ��Ͳ���
	 * �Զ�װ�䣺ָ������Ա���԰�һ��������������ֱ�Ӹ�ֵ����Ӧ�İ�װ��
	 * �Զ����䣺ָ������Ա���԰�һ����װ�����ֱ�Ӹ�ֵ����Ӧ�Ļ�����������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//jdk5.0����֧���Զ�װ��Ͳ���
		Integer i=1;//�Զ�װ�䣬�ȼ���Integer i=new Integer(1);,���Զ���������������װ���һ������
		
		int j=i;//�Զ������������java�ڲ��Զ���һ�������װ�Ļ����������ݸ�����Ӧ�Ļ������ͱ���
		
		
		//����Ӧ�ã�
		List list=new ArrayList();
		list.add(1);//add����Ĭ�ϲ�����һ���������ͣ������Զ�װ�����֮�󣬿��Խ���������ֱ��ʹ��add������ӵ�����У�java���Զ�����װ��ɶ���
		list.add(2);//��==��list.add(new Integer(1))
		list.add(3);
		
		Iterator it=list.iterator();
		while(it.hasNext()){
			int k= (Integer)it.next();//�Զ����似�������ص�integer�����е������Զ�����ɻ�������
		}
	}
	

}
