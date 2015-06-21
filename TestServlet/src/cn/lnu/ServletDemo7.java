package cn.lnu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����servletContextʵ������ת������νת����ָ������ڷ������servletDemo7web��Դʱ������Դû��������������Դ���������Ὣ������ת������Դ�ĵ�ַ��������jspҳ��
public class ServletDemo7 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data="aaa";
		//�����ݴ���1.jsp��������ý����ݱ��浽servletContext�򣬵���һ�����Ƕ�����ô������Ϊ������ݻᱻ����web��Դ������Ϊ�����̰߳�ȫ����
		//����ʵ�ʿ����н����ݴ���jsp����ͨ��context�򣬶���ͨ��request��������ʱ����context������ݸ�jsp
		this.getServletContext().setAttribute("data", data);
		
		
		//���Ȼ��servletת������
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/1.jsp");
		//����ת�������forward����������ת����1.jspҳ��
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
