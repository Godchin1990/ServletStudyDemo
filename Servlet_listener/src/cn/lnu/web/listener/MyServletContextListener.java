package cn.lnu.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//����webӦ�õ����������٣����Զ�web��Դ����һЩ��ʼ������
public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//System.out.println("servletContext�����٣�");
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//System.out.println("servletContext��������");
	}

}
