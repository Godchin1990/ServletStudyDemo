package cn.lnu.thread.example;

public class Main {//���߳�

	/**
	 * ��������������ʵ�ַ�Ʊ����Ʊ����
	 * 
	 * ��Consumer�߳��۳�Ʊ��availableֵ��Ϊfalse����Producer�̷߳���Ʊ��
	 * availableֵ��Ϊtrue��ֻ��availableΪtrueʱ��Consumer�̲߳�����Ʊ������
	 * �ͱ���ȴ�Producer�̷߳����µ�Ʊ��֪ͨConsumer��Ʊ����֮��ֻ��availableΪfalseʱ��
	 * Producer�̲߳��ܷ�Ʊ���������ȴ�Consumer�߳��۳�Ʊ����֪ͨProducer��Ʊ
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tickets t=new Tickets(10);//������Ʊ��10��
		Producer p=new Producer(t);//������Ʊ���߳�
		Consumer c=new Consumer(t);//������Ʊ���߳�
		//�����̣߳�ʵ�ַ�Ʊ10�ţ���Ʊ10�ŵĹ���
		p.start();
		c.start();
		
	}

}
