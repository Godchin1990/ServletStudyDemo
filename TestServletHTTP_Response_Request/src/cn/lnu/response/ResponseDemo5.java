package cn.lnu.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�����������ʱˢ��
public class ResponseDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(response);
		//test2(response);
		test3(request,response);
	}
	//�ǳ�ʵ�õĶ�ʱ��תҳ�漼��
	private void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//����ʵ�ʿ����У�����һ���û������½��servlet
		
		//������򵽴ˣ��û���½�ɹ�
		String message = "<meta http-equiv='refresh' content='3;url=/TestServletHTTP_Response_Request/index.jsp'>��ϲ�㣬��½�ɹ���������3�����ת����ҳ�����û����ת������<a href='#'>������</a>";
		this.getServletContext().setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	private void test2(HttpServletResponse response) throws IOException {
		//����ʵ�ʿ����У�����һ���û������½��servlet
		
		//������򵽴ˣ��û���½�ɹ�
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh","3;url='/TestServletHTTP_Response_Request/index.jsp'");
		response.getWriter().write("��ϲ�㣬��½�ɹ���������3�����ת����ҳ�����û����ת������<a href='#'>������</a>");
	}

	private void test1(HttpServletResponse response) throws IOException {
		//���������ˢ��ʱ��Ϊ3��
		response.setHeader("refresh", "3");
		
		String data=new Random().nextInt(10000)+"";
		PrintWriter out=response.getWriter();
		out.write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
