package cn.lnu;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���webӦ�õĳ�ʼ������
public class ServletDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����webӦ�õĲ��������webӦ�õĲ���ֵ
		/*String value=this.getServletContext().getInitParameter("contextparm");
		System.out.println(value);*/
		
		//�������webӦ�ó�ʼ������
		Enumeration e=this.getServletContext().getInitParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String value=this.getServletContext().getInitParameter(name);
			System.out.println(name+"  "+value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
