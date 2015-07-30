package cn.lnu.thread.newInfo;

public class ProducerConsumerDemo2 {

	/**JDK1.5
	 *����˶������߶������ߵ�Ч�ʵ�������
	 *ʹ����JDK1.5 java.util.concurrent.locks���еĶ���
	 *Lock�ӿڣ����ĳ��ֱ�synchronized�и���Ĳ�����
	 *			lock():��ȡ��
	 *			unlock():�ͷ���
	 *ͬ����������ͬ������������������ʽ�ġ�
	 *JDK1.5 Lock�ӿڣ�������������˼�룬����������װ����һ�����󣬲��ṩ�˶�������ʾ������
	 *Lock�ӿھ���ͬ�������
	 *1���������е�1.4ͬ������Ϊlock�ӿڵ���ʽ
	 *2,�滻��֮������ʧ���ˣ���Ϊwaitû����ͬ������û����������ͬ������
	 *ͬ�������ˣ��������Ѿ�������������󣬶���Lock���͵Ķ���
	 *��ô���������󶨵ļ������������ǲ���Ҳ�����ˣ�����ר�ź�Lock�������İ󶨵ļ����������𣬴Ӷ�����֮ǰ��wait��motify��notifyAll
	 *����api,Condition�ӿ������Object�еļ�����������
	 *��ǰ������������װ��ÿ�������У����ڽ�������������װ����Condition������
	 *������Ϊ��await,signal signalAll
	 *
	 *����������Condition�����Lock����
	 *����ͨ��Lock�ӿڵ�newCondition()�������
	 *�����������ɣ�һ�������˱�����Ч�����ɵ���
	 *���Դ�������lock���ļ������������߼������������߼����������ڻ��ѶԷ����������ỽ�ѱ����Ӷ������Ч�����⡣
	 */
	public static void main(String[] args) {
		//1��������Դ
		Resource2 r2=new Resource2();
		//2,����������������������
		Producer2 p=new Producer2(r2);
		Consumer2 c=new Consumer2(r2);
		//3�������߳�
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		Thread t3=new Thread(c);
		Thread t4=new Thread(c);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
