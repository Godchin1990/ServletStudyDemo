package cn.lnu.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
	
	public static void main(String[] args){
		List list=new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		
		//Iterator it=list.iterator();//��СΪ4
		//Ϊ���Ⲣ���޸��쳣����������ʹ�õ������ĺ��ӣ���������ɾ�Ĳ�Ĺ��ܣ��ڵ���Ԫ�ص�ͬʱ����ɾ�Ĳ鲻����ֲ����޸��쳣����
		ListIterator it=list.listIterator();
		while(it.hasNext()){
			String str=(String) it.next();
			//list.add("eee");//java.util.ConcurrentModificationException���ϵĲ����޸��쳣��Ϊ�˱��������쳣�����ǿ��Ե��õ������ķ���������Ԫ�صĲ���
			it.add("eee");//ʹ���ӵ������ķ��������ɾ�Ĳ����⣬������������֪�������ɾ�Ĳ�������������׳������޸��쳣
		}
	}
}	
