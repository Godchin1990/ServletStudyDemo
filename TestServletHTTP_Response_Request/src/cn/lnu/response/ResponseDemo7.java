package cn.lnu.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ʵ�������ض���
/*
 �ض�����ص㣺
 * 1�����������������������Σ���ζ�������2��request/response
 * 2.���ض��������������ַ���ᷢ���仯
 * 
 ֻ��һЩ�ض��ĳ����²��õ��ض�������һ�����û���¼����ʾ���ﳵʱ
 * */
public class ResponseDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*response.setStatus(302);
		response.setHeader("location", "/TestServletHTTP_Response_Request/index.jsp");*/
		response.sendRedirect("/TestServletHTTP_Response_Request/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
