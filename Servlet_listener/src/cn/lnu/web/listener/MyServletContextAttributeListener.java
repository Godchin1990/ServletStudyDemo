package cn.lnu.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements
		ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		String Attrname=scab.getName();
		Object AttrValue=scab.getValue();
		System.out.println("��servletContext�д���"+Attrname+"="+AttrValue);
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("��servletContext��ɾ����"+scab.getName()+"����");
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("servletContext�е�"+scab.getName()+"����ֵ���滻��");
	}

}
