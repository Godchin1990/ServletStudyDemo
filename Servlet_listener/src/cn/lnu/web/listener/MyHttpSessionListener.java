package cn.lnu.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//��������ͳ����վ��������
public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//System.out.println("session��������");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//System.out.println("session�����٣�");
	}

}
