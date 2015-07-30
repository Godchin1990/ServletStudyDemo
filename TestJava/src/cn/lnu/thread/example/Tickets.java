package cn.lnu.thread.example;


public class Tickets {
	private int size;//Ʊ����
	private int number=0;//��Ʊ���
	private boolean available=false;//�Ƿ��д��۵�Ʊ
	
	public Tickets(int size){
		this.size=size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public synchronized void put() {//��Ʊ,ÿ�η�һ��Ʊ
		if(available){//������д�Ʊ���ۣ����Ʊ�̵߳ȴ�
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Producer puts ticket "+(++number));
		available=true;
		notify();//��Ʊ������Ʊ�߳̿�ʼ��Ʊ
	}
	
	public synchronized void sell() {//��Ʊ��ÿ����һ��Ʊ
		if(!available){//�����ǰ��Ʊ���ۣ�����Ʊ�̵߳ȴ�
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Consumer buys ticket "+(number));
		available=false;
		notify();//��Ʊ���ѷ�Ʊ�߳̿�ʼ��Ʊ
		if(number==size) number=size+1;//���������һ��Ʊ������һ��������־��number>size��ʾ��Ʊ����
	}
	
}
