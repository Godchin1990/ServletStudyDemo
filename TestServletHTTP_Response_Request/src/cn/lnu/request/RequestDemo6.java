package cn.lnu.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//forward��Ҫע���ϸ�ڣ����´�����׳��쳣
public class RequestDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message="I am a student.";
		
		request.setAttribute("message", message);
		
		if(true){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			//return;//����return������ͻ��׳��쳣
		}
		//���������׳�java.lang.IllegalStateException: Cannot forward after response has been committed�쳣�����벻�������
		//����쳣������Ҫ��ÿ����ת֮�����return���
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
