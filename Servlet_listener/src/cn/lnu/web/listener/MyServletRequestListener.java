package cn.lnu.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
//��������ͳ����վ����
public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		//System.out.println("request�����٣�");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		//System.out.println("request��������");
	}

}
