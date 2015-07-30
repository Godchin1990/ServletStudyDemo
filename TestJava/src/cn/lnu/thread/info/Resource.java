package cn.lnu.thread.info;
//������-�����߶���Ҫ��������Դ
public class Resource {
	private String name;
	private int count=1;
	private boolean flag=true;//��ʾ�����������
	//�ṩһ���������߸���Դ��ֵ�ķ���
	public synchronized void setRes(String name){
		if(flag){//�жϱ��Ϊtrue,ִ��wait�ȴ���Ϊfalse������
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		this.name=name+"---"+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"------������------"+this.name);
		//������ϣ�����Ǹ�Ϊtrue
		flag=true;
		//����������
		notify();
	}
	//�ṩһ���������߻�ȡ��Ʒ�ķ���
	public synchronized void getRes(){
		if(!flag){//���û����Ʒ�������ѣ���ȴ�
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"------------������---------"+this.name);
		//������ϣ�����Ǹ�Ϊfalse
		flag=false;
		//����������
		notify();
	}
}
