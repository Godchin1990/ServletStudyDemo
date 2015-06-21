package cn.lnu.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//request���÷���
public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ӡ��ǰ������Դ��URI��URL,URI�õĺܶ�
		System.out.println(request.getRequestURI());// /TestServletHTTP_Response_Request/servlet/RequestDemo1
		System.out.println(request.getRequestURL());// http://localhost:8080/TestServletHTTP_Response_Request/servlet/RequestDemo1
		//�������ַ����http://localhost:8080/TestServletHTTP_Response_Request/servlet/RequestDemo1?name=mushroom&&passwd=123456 ?֮���ʾ��ѯ�ִ�
		System.out.println(request.getQueryString());//���ز�ѯ�ִ�
		
		//�õ�������(һ���ǿͻ���)��IP��ַ
		System.out.println(request.getRemoteAddr());
		//���ط�������Ŀͻ����������������������������ͻ���û����DNS��ע��IP�����Ǵ�ӡIP��ַ��
		System.out.println(request.getRemoteHost());
		//���ط�������Ŀͻ�����ʹ�õ�����˿ں�
		System.out.println(request.getRemotePort());
		
		//����web��������IP��ַ
		System.out.println(request.getLocalAddr());
		
		//����web��������������
		System.out.println(request.getLocalName());
		
		//���ط�������Ŀͻ���������ʽ
		System.out.println(request.getMethod());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
