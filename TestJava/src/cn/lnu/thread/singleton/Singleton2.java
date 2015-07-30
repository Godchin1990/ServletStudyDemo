package cn.lnu.thread.singleton;
//����ʽ�������ģʽ���ӳټ���ģʽ������ʱ�����ֱȽ϶�
/*
 * 	�ڶ��̲߳�������ʱ��������̰߳�ȫ���⣬
 * ����ͬ���Ϳ��Խ�����⣬������ͬ������������ͬ������鶼�У�������ô��Ч�ʵ��ˣ���Ϊÿ�ο���һ���̶߳���Ҫȥ�ж������˷���Դ������ʵ��ֻ��Ҫ��һ�η���ʱ����Ҫ�ж���
 * 
 * ��ô��ν��Ч�ʵ͵����⣿
 * ����ͨ��if�Ե��������˫���жϵ���ʽ����˫У����
 * */
public class Singleton2 {
	private static Singleton2 instance=null;
	private Singleton2(){
		
	}
	
	/*public static Singleton2 getInstance(){
		if(instance==null){
			instance=new Singleton2();
		}
		return instance;
	}*/
	
	/*public static synchronized Singleton2 getInstance(){
	if(instance==null){
		instance=new Singleton2();
	}
	return instance;
}*/
	public static Singleton2 getInstance(){
		
		if(instance==null){
			
			synchronized(Singleton2.class){//��̬����ʹ�����ֽ����ļ�������Ϊ��
				if(instance==null){
					instance=new Singleton2();
				}
			}
		}
		return instance;
	}
	
	
}
