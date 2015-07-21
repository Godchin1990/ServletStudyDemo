package cn.lnu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//����ע������
public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");	
		}
		//ע���ɹ���������ȫ����Ϣ��ʾҳ�棬��������Ϣ��ʾҳ���3�����ת����ҳ
		request.setAttribute("message", "��ϲ��,ע���ɹ�,���������3��֮����ת����ҳ�������û����ת����������<a href='"+request.getContextPath()+"/index.jsp'>��ת����ҳ</a><meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
