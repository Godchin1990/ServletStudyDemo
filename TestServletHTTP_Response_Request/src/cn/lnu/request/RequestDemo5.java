package cn.lnu.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����ת�����Լ�ʹ��request���������ݴ���ת����Դ
//����ת���ص㣬�ͻ���ֻ����һ�����󣬶����������ж����Դ���ã��ͻ����������ַ��û�б仯
public class RequestDemo5 extends HttpServlet {

	/*
	 * MVC (model(���Կ���javaBean) view(���Կ���jsp) controller�����Կ���Servlet��)
	 * Ҳ����servlet����������յ�����������ݣ���������֮��ʹ��javaBean���Model����װ��
	 * Ȼ��servlet�����������ʺ�����������ǰ�javaBean�浽request����ʹ��forward��������jsp���view����jsp���view
	 * ȡ�������������ʾ
	 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data="mushroom";
		//�����������ݴ���ת����Դ������ʵ�ʿ�����һ�㲻���ô˷���
		//this.getServletContext().setAttribute("data", data);
		
		//һ��ʹ��request������ݸ�jsp��ʾ��
		request.setAttribute("data", data);
		//request����Ҳ��ʵ��ת��
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
