package cn.lnu.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����������˲��õ���UTF-8����
public class RequestDemo4 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(request);
		test2(request);
	}
	//�����Get��ʽ�ύ��������������
	private void test1(HttpServletRequest request)
			throws UnsupportedEncodingException {
		
		String username=request.getParameter("username");
		
		//�����GET��ʽ�ύ���������ݣ�ֻ���Լ��ֶ��޸ķ����ַ�����������Ȼ��request��iso8859-1����֮�������֮�����������µ����(�����뵱ǰ��������һ��)ת����ǰ�����γ�һ���ַ���
		username=new String(username.getBytes("iso8859-1"),"UTF-8");
		
		System.out.println(username);
	}

	//�����POST��ʽ�ύ�������������⣬ֻ��Ҫ����һ��request�����Ϊ�����ʹ�õ����������ʹ��Ĭ�ϵ�iso8859-1���
	private void test2(HttpServletRequest request)
			throws UnsupportedEncodingException {
		
		//����requestӦ��ʹ�õ�����������ַ���ֻ�ܴ�����Post��ʽ�ύ������
		request.setCharacterEncoding("UTF-8");
		
		String username=request.getParameter("username");
		System.out.println(username);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
