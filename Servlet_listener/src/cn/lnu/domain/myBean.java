package cn.lnu.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class myBean implements HttpSessionActivationListener,Serializable {//ʵ��������ӿڵ�beanҲ������web.xml��ע�����������Ϊ�����������Լ�

	public void sessionDidActivate(HttpSessionEvent se) {//��������������javabean������session����ڴ�
		// TODO Auto-generated method stub 
		System.out.println("myBean����session��Ӳ�̻ص�����ڴ����ˣ���");
	}

	public void sessionWillPassivate(HttpSessionEvent se) {//��������������javabean������session�ۻ�������
		// TODO Auto-generated method stub
		System.out.println("myBean����session���ڴ�ص��ۻ����������ˣ���");
	}

}
