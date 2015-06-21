package cn.lnu.url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//url�����д����Ҫ�����url���ṩ��˭�ã�����������߷������� /�ĺ��岻ͬ
public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 ���������ã�/��ʾwebӦ�ü��Ǵ����Ǹ�WebRoot
		request.getRequestDispatcher("/form.html").forward(request, response);
		
		//2 ��������ã�/��ʾ��վ��ַ
		response.sendRedirect("/TestServletHTTP_Response_Request/form.html");
		
		//3���������ã�/��ʾwebӦ�ü��Ǵ����Ǹ�WebRoot
		this.getServletContext().getRealPath("/form.html");
		
		//4 ���������ã�/��ʾwebӦ�ü��Ǵ����Ǹ�WebRoot
		this.getServletContext().getResourceAsStream("/public/head.jsp");
		
		
		//5
		/*��������õĻ���/��ʾ��վ��ַ
		 * <a href="/TestServletHTTP_Response_Request/form.html">����</a>
		 * 
		 * <form action="/TestServletHTTP_Response_Request/form.html">
		 * 
		 * </form>
		 * 
		 * 
		 * */
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
