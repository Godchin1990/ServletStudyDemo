package cn.lnu;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//servletContextʾ��
public class ServletDemo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���servtContext����ķ���һ
		//ServletContext context=this.getServletConfig().getServletContext();
		//���servtContext����ķ�����
		ServletContext context=this.getServletContext();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
