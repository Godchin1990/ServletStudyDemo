package cn.lnu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lnu.domain.User;
import cn.lnu.service.impl.BusinessServiceImpl;
//�����½ҳ������
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��֤�û��ύ���û���������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		BusinessServiceImpl service=new BusinessServiceImpl();
		User user=service.login(username, password);
		if(user!=null){
			//����û���½�ɹ�������session���һ����½��ǣ���ǳɹ���½
			request.getSession().setAttribute("user", user);
			//���û���½�ɹ�����ת����ҳ
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		//�����½ʧ�ܣ�������ת��ȫ����Ϣ��ʾҳ�棬���û��Ѻ���ʾ
		request.setAttribute("message","�û�����������󣡣�");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
