package cn.lnu.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//forwardϸ��2:forwardʱ�������response�е����ݣ����ǲ����Ѿ�д�뵽HttpServletResponse�������Ӧͷ�ֶ���Ϣ�����֣�������ֻ�ܿ���index.jspҳ���ԭʼ���ݣ����ǿ�������д���aaaa
public class RequestDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data="aaaa";
		response.getWriter().write(data);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
