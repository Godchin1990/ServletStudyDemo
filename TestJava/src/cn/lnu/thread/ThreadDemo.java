package cn.lnu.thread;

public class ThreadDemo {

	/**
	 *����ͨ��һ��ʵ��Runnable�ӿڵĶ���ʵ�ֶ��߳���Ʊ����,ʹ��ͬ�������ʵ���߳�ͬ��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main thread is start.");
		
		SellTickets t=new SellTickets();
		
		Thread thread1=new Thread(t,"thread1");
		Thread thread2=new Thread(t,"thread2");
		Thread thread3=new Thread(t,"thread3");
		//�������߳�
		
		thread1.start();
		thread2.start();
		thread3.start();
	
		System.out.println("sell thread is start,main thread is end.");
	}

}
