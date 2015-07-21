package cn.lnu.eclipse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public class Demo4 {

	/**
	 * java��ǿforѭ��
	 */

	@Test
	public void test1() {
		int atrr[] = { 1, 2, 3, 4, 5 };
		for (int num : atrr) {
			System.out.print(" " + num);
		}
		System.out.println();
	}

	@Test
	public void test2() {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for (Object obj : list) {
			int i = (Integer) obj;
			System.out.println(i);
		}
	}

	// map���ϲ�����ֱ�ӵ�����Ҫ�����map���������·�ʽ��
	@Test
	public void test3() {
		Map map = new LinkedHashMap();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		System.out.println("-----------��ͳ����map���Ϸ�ʽһ--------------------");
		// ��ͳ��ʽ1����map,�Ƚ�map���ϵ�keyת��Ϊһ��set����
		Set set = map.keySet();

		Iterator it = set.iterator();
		while (it.hasNext()) {// ��������ÿ��Ԫ�ض���һ��ԭmap�����е�key
			String key = (String) it.next();
			String value = (String) map.get(key);
			System.out.println(key + ":" + value);
		}
		System.out.println("-----------��ͳ����map���Ϸ�ʽ��--------------------");
		// ��ͳ��ʽ2����map
		Set set2 = map.entrySet();// ÿ��Ԫ����һ����ԭ��map�����еļ�ֵ��(Map.entry)
		Iterator it2 = set2.iterator();
		while (it2.hasNext()) {
			Map.Entry entry = (Entry) it2.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println(key + ":" + value);
		}

	}

	@Test
	public void test4() {
		Map map = new LinkedHashMap();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");

		System.out
				.println("-----------ʹ����ǿforѭ������map����Ԫ�صĵ�һ�ַ�ʽ(��Ӧ��ͳ��ʽһ)--------------------");

		for (Object obj : map.keySet()) {// ��������Ԫ�ض���һ����ԭmap�����е�key
			String key = (String) obj;
			String value = (String) map.get(key);
			System.out.println(key + ":" + value);
		}

		System.out
				.println("-----------ʹ����ǿforѭ������map����Ԫ�صĵڶ��ַ�ʽ(��Ӧ��ͳ��ʽ��)--------------------");

		for (Object obj : map.entrySet()) {// ����������ÿ��Ԫ�ض���ԭ��map�����еļ�ֵ��(Map.entry)
			Map.Entry entry = (Entry) obj;
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println(key + ":" + value);
		}
	}

	// ʹ����ǿforѭ����Ҫע��ļ������⣺��ǿforѭ��ֻ�ʺ�ȡ����,����Ҫ�޸�����򼯺��е����ݣ���Ҫʹ�ô�ͳ��ʽ
	@Test
	public void test5() {
		int atrr[] = { 1, 2, 3, 4, 5 };
		for (int i : atrr) {
			i = 10;
		}
		System.out.println(atrr[0]);//1
		System.out.println(atrr[1]);//2
		System.out.println(atrr[2]);//3
		System.out.println(atrr[3]);//4
		System.out.println(atrr[4]);//5
		
		System.out.println("--------------------------");
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for (Object obj : list) {
			obj=9;
		}
		
		System.out.println(list.get(0));//1
	}

}
