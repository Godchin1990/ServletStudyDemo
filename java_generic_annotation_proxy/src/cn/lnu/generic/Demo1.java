package cn.lnu.generic;

public class Demo1 {
	
	public static void main(String[] args) throws ClassNotFoundException{
		Demo1 d1=new Demo1();
		
		System.out.println(d1.getClass());//class cn.lnu.generic.Demo1
		System.out.println(d1.getClass().getName());//cn.lnu.generic.Demo1
		System.out.println(d1.getClass().getSimpleName());//Demo1
		System.out.println(d1.getClass().getCanonicalName());//cn.lnu.generic.Demo1
		System.out.println(d1.getClass().getGenericSuperclass());//class java.lang.Object
	}
	
	//��дһ�����η���������һ���������飬���ߵ������е�����Ԫ�ء�
	public <T> void reverse(T arr[]){
		int startindex = 0;
		int endindex = arr.length-1;
		while(true){
			if(startindex>=endindex){
				break;
			}	
			T temp = arr[startindex];
			arr[startindex] = arr[endindex];
			arr[endindex] = temp;
			startindex++;
			endindex--;
		}
	}
}
