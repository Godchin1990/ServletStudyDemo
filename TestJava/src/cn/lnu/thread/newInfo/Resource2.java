package cn.lnu.thread.newInfo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//��������-�����߶���Ҫ��������Դ
public class Resource2 {
	private String name;
	private int count=1;
	private boolean flag=true;//��ʾ�����������
	//������Lock��
	private Lock lock=new ReentrantLock();
	//������Lock�󶨵ļ���������,��������
	//�����߼�������lock����
	private Condition producer_con=lock.newCondition();
	//�����߼�������lock����
	private Condition consumer_con=lock.newCondition();
	//�ṩһ���������߸���Դ��ֵ�ķ���
	public void setRes(String name){
		//�����
		lock.lock();
		try{
			while(flag){//�жϱ��Ϊtrue,ִ��wait�ȴ���Ϊfalse������
				try {
					producer_con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
			this.name=name+"---"+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"------������------"+this.name);
			//������ϣ�����Ǹ�Ϊtrue
			flag=true;
			//������ϣ�Ӧ�û���һ��������������
			consumer_con.signalAll();
		}finally{
			//�ͷ���
			lock.unlock();
		}
	}
	
	//�ṩһ���������߻�ȡ��Ʒ�ķ���
	public void getRes(){
		//�����
		lock.lock();
		try{
			while(!flag){//���û����Ʒ�������ѣ���ȴ�
				try {
					consumer_con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"------------������---------"+this.name);
			//������ϣ�����Ǹ�Ϊfalse
			flag=false;
			//������ϣ�Ӧ�û���һ������������
			producer_con.signalAll();
		}finally{
			//�ͷ���
			lock.unlock();
		}
		
	}
}
