package cn.lnu.eclipse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo5 {

	/**
	 * java�ɱ����
	 */
	
	@Test
	public void testSum(){	
		
		//sum(1,2,3,4,5,6,7);
		
		//Ҳ���Դ���һ������
		int arr[]={1,2,3,4,5,6,7};
		sum(arr);
	}
	
	public void sum(int ...nums){
		//�ɱ�����ɰ�������������
		int sum=0;
		for(int i:nums){
			sum+=i;
		}
		System.out.println(sum);
	}
	
	
	@Test
	public void testAa(){
		sum(1,2,3,4,5,6,7);
	}
	//�ɱ������Ҫע�������:public void aa(int ...nums,int x){�����ʽ����ɱ��������
	
	public void aa(int x,int ...nums){
		
	}
	
	@Test
	public void bb(){
		List list=Arrays.asList("1","2","3");
		System.out.println(list);//[1, 2, 3]
		
		String arr[]={"1","2","4","5"};
		list=Arrays.asList(arr);
		System.out.println(list);//[1, 2, 4, 5]
		
		int nums[]={1,2,3,4,5,6};//Arrays.asList���յĿɱ����������һ��������java�л�����������������Ϊ��һ������
		list=Arrays.asList(nums);
		System.out.println(list);//[[I@4e79f1]
		
		Integer nums2[]={1,2,3,4,5,6};
		list=Arrays.asList(nums2);
		System.out.println(list);//[1, 2, 3, 4, 5, 6]
	}
	
}
