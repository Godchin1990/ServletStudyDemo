package cn.lnu.web.listener.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//�Զ���sessionɨ����
public class SessionScannerListener implements HttpSessionListener ,ServletContextListener{
	
	private List<HttpSession> list=Collections.synchronizedList(new LinkedList<HttpSession>());
	private Object lock=new Object();//����һ�����������δ��빲��
	
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session=se.getSession();
		System.out.println(session+"������");
		synchronized(lock){//���û���½���򼯺�������µ�Ԫ��ʱ�����õ�ͬ�������������
			list.add(session);//�����̰߳�ȫ����,����ʹ��Collections.synchronizedList(List<T>)�Ϳ��Է���һ���̰߳�ȫ��list
		}
			
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println(se.getSession()+"���ݻ�");
	}

	//Ϊ��ʵ��ÿ�����ɨ��һ��session��û�����ã�������Ҫ����һ����ʱ�����������ʱ����Ҫ����webӦ�õ����������������Ի���Ҫʵ��ServletContextListener�ӿڣ�ʵ�ֶ�ʱ���Ĵ�����session��ɨ��
	public void contextInitialized(ServletContextEvent sce) {//webӦ��������ʱ�򣬾�������ʱ��
		// TODO Auto-generated method stub
		//����һ����ʱ��
		Timer timer=new Timer();
		timer.schedule(new myTask(list,lock), 0, 1*60*1000);//��ͬ����lockҲ���ݹ�ȥ
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}

//����������ÿ��5����ɨ��һ��list��ϣ���������е�Ԫ��session����������˷��ʾʹӼ�����ɾ��
class myTask extends TimerTask{
	private List list;
	private Object lock;//�������û���¼��վ���session����ŵ�һ��ͬ��������У����Դ˴�����Ҫ����һ��ͬ����
	myTask(List list,Object lock){
		this.list=list;
		this.lock=lock;
	}
	@Override
	public void run() {
		//System.out.println("��ʱ��ִ�У�");
		synchronized(this.lock){//�����ڵ�����������ʱ���û��µ�¼���򼯺�������µ�session������������ʱҲ��֪�������������޸��쳣
			//Iterator it=list.iterator();//��ü��ϵĵ�����
			ListIterator it=list.listIterator();
			while(it.hasNext()){
				HttpSession session=(HttpSession) it.next();
				if((System.currentTimeMillis()-session.getLastAccessedTime())>1*60*1000){
					session.invalidate();//������session5������û�˷��ʾʹݻ���
					//list.remove(session);//������ڼ��ϵ����Ĺ�����ɾ��Ԫ�أ���ʱ����������֪�����������޸�(����ָɾ��Ԫ��)�����׳�һ�������޸��쳣��
					it.remove();//���ڵ�ǰ���������ڵ������session���������ǲ���Ҫ���ݲ���session��remove����
				}
			}
		}
	}
}
