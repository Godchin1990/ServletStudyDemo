package cn.lnu.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//������  http://localhost:8080/TestServletHTTP_Response_Request/servlet/ResponseDemo9
public class RequestDemo9 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��֤������
		String referer=request.getHeader("referer");
		if(referer==null||!referer.startsWith("http://localhost")){//������ת����ҳ
			response.sendRedirect("/TestServletHTTP_Response_Request/index.jsp");
			return;
		}
		
		//���������������
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		String data="СĢ����Servletѧϰ�ռǣ�";
		response.getWriter().write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
