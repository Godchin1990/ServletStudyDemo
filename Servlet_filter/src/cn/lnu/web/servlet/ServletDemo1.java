package cn.lnu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����������ȫվ���룬����Ͳ�����ǰһ����Ҫһ�������Ƚ��������������
		String username=request.getParameter("username");
		response.getWriter().write("�й�");
		//���ǰ̨��������д�ŵ���js���룬��Ҫ����ת����ܴ浽���ݿ⣬��getParameter������ݵĲ��������ת�壬�����Ժ�ȥ���ݿ���ȡ������ʱ����δ���ᱻִ�У�
		String resume=request.getParameter("resume");
		response.getWriter().write(resume);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
