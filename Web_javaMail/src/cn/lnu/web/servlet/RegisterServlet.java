package cn.lnu.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lnu.domain.User;
import cn.lnu.utils.SendMail2;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		try{
			//�����ݿ�ע���û�
			
			//����һ���߳����û���һ���ʼ�
			/*SendMail send=new SendMail(user);
			send.start();//�����̣߳�����������Զ�����������run������ִ����user�����ʼ�����*/
			
			Thread t=new Thread(new SendMail2(user));
			t.start();
			
			request.setAttribute("message", "ע��ɹ�,�����Ѿ����㷢��һ���ʼ����뼰ʱ���գ�");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "ע��ʧ�ܣ�");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
