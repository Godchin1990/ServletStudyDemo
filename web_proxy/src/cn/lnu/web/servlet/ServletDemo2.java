package cn.lnu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().write("�й�");//���ʱ����servlet���response����ʵ���������������е�responseProxy������getWriter����д�����ݲ�û��ֱ��д�������������д���ײ㻺�������ˣ�Ȼ�󾭹�ѹ����д�������
		response.getOutputStream().write("hahfalkhfĢ��".getBytes());//hahfalkhfĢ��
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request,response);
	}

}
