package cn.lnu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����������������Ʒ������Ϣ�������䣬���Խ����ݻ��棬����ÿ�ζ�ȥ�������ݿ⣬��������վ����
public class ServletDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ѯ���ݿ⣬�����Ʒ������Ϣ
		String data="������Ϣ";
		//���������Ϣ
		response.getWriter().write(data);
		
		System.out.println("ServletDemo4ִ��,,,");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
