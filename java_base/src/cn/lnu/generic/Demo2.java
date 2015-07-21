package cn.lnu.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

//���ͼ������ݵĴ�ȡ��ʹ�÷���֮�󣬾Ϳ��Ա���ӷ��ͼ�����ȡ����ʱ������ǿ��ת��
public class Demo2 {
	
	@Test
	public void test1(){
		
		List<String> list=new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		System.out.println("-----------��ͳ��ʽ������������------------");
		//��ͳ��ʽ��ȡ��������
		Iterator<String> it=list.iterator();//����iterator�����������String����,�õ����ϵĵ�����
		while(it.hasNext()){
			String str=it.next();
			System.out.println(str);
		}
		System.out.println("-----------��ǿfor������������------------");
		//ʹ����ǿfor
		for(String str1:list){
			System.out.println(str1);
		}
	}
	
	//HashMap�Ǹ��ݹؼ��ֵ�hashֵ��ȷ����ֵ�Դ��λ�ã����Բ��������ţ���LinkedHashMap����ʹ������ķ�ʽ���Ԫ��������������
	@Test
	public void test2(){
		
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();//����һ������ȥָ��һ��map���ϣ��������ͨ��<Integer,String>˵������new���ļ��ϵĴ������͵Ĺؼ���Ϊint�ͣ�ֵΪString���ͣ�����ָ�������ͱ����Ǹ����󣬲����ǻ�������
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		map.put(4, "dd");
		System.out.println("-----------��ͳ��ʽ��Map.keySet������������------------");
		//��ͳ��ʽ1(ʹ��map.ketSet����)��ȡ��������
		Set<Integer> set=map.keySet();//����iterator�����key������Integer����,�õ����ϵĵ�����
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()){
			int key=it.next();
			String value=map.get(key);
			System.out.println(key+":"+value);
		}
	}
	
	@Test
	public void test3(){
		
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();//����һ������ȥָ��һ��map���ϣ��������ͨ��<Integer,String>˵������new���ļ��ϵĴ������͵Ĺؼ���Ϊint�ͣ�ֵΪString���ͣ�����ָ�������ͱ����Ǹ����󣬲����ǻ�������
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		map.put(4, "dd");
		System.out.println("-----------��ͳ��ʽ��Map.entrySet������������------------");
		//��ͳ��ʽ2(ʹ��map.entrySet����)��ȡ��������
		Set<Map.Entry<Integer, String>> set=map.entrySet();//�Ƚ�map.entrySet���ص�һ����entry���浽һ��Set�����У���������ĵ���
		Iterator<Map.Entry<Integer, String>> it=set.iterator();//���ߵ�����ȡ����ÿ��Ԫ�ض���һ����Map.Entry���͵ļ�ֵ�ԡ�����������Integer��ֵ��������String
		while(it.hasNext()){
			Map.Entry<Integer, String> entry=it.next();
			int key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+":"+value);
		}
	}
	
	//ʹ����ǿforѭ������map�����е����ݣ��ص㣩
	@Test
	public void test4(){
		
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();//����һ������ȥָ��һ��map���ϣ��������ͨ��<Integer,String>˵������new���ļ��ϵĴ������͵Ĺؼ���Ϊint�ͣ�ֵΪString���ͣ�����ָ�������ͱ����Ǹ����󣬲����ǻ�������
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		map.put(4, "dd");
		System.out.println("-----------��ǿforѭ��������������------------");
		
		for(Map.Entry<Integer, String>entry:map.entrySet()){//����������һ��Map.Entry,entry(��Ŀ)�ļ�ֵ�����Ͷ�Ӧ��Integer��String����
			int key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+":"+value);
		}
	}
	
	
	//ʹ�÷���ʱ��Ҫע�������
	@Test
	public void test5(){
		//ʹ�÷���ʱ��������߶�ʹ�÷��ͣ�������������Ҫ������������ͱ���һ��
		//ArrayList<Object> list=new ArrayList<String>(); //����д��
		//ArrayList<String> list=new ArrayList<Object>(); //����д��
		
		//ʹ�÷���ʱ�����ֻ��һ��ʹ���˷��ͣ���Ͳ���������⣬����sun��˾Ϊ���Ǽ����Թ�����ô��Ƶ�
		ArrayList<String> list=new ArrayList();//��ȷ,Ϊ�˿��ǵ��ͼ�����Ա���ø߼�����Աʹ�÷��ͱ�д�ĺ����ļ�����
		ArrayList list1=new ArrayList<String>();//��ȷ��sun��˾Ϊ�˿��ǵ�jdk1.5֮ǰû�з��ͣ�֮��汾���з��͵ļ�����
		
		
	}
}
