package cn.lnu.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���û�������cookie֮�󣬿��Բ�������ҳ��дurl�ķ�ʽ�����ַ�ʽ����дurl֮�����֮��׷��һ��sessionid
public class WelcomeSessionDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���������������
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		request.getSession();
		
		String url1=response.encodeURL("/TestServletHTTP_Cookie_Session/servlet/SessionDemo1");
		String url2=response.encodeURL("/TestServletHTTP_Cookie_Session/servlet/SessionDemo2");
		out.print("<a href='"+url1+"'> ����</a>");
		out.print("<a href='"+url2+"'> ����</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
