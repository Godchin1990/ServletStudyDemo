package cn.lnu.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//����һ��javaBean User����������Լ���û�а󶨵�һ��session��ȥ�����������javabean��ʵ��HttpSessionBindingListener����ӿڣ����Ҳ���Ҫ��web.xml��ע��������ˣ���Ϊ�����Ǽ����������¼�Դ
public class User implements HttpSessionBindingListener {

	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("user�����Լ����浽session���ˣ���");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("user�����Լ���session�нӴ����ˣ���");
	}

}
