package cn.lnu.thread.singleton;

public class SingletonRun implements Runnable {

	public void run() {
		//singleton1.getInstance();//�ᱻ���̲߳������ʣ������¶���ʽ��������singleton1��һ����ʱ�ͱ�����������ڶ��̷߳��ʹ����в�������̰߳�ȫ����
		Singleton2.getInstance();//����ʽ����������Ҫ��ʱ��Ŵ���ʵ���������̰߳�ȫ���⣬����ʹ��˫У����������ʵ���̰߳�ȫ��ͬʱ���������ж�ͬ������ɵ�ִ��Ч�ʵ�������
	}

}
