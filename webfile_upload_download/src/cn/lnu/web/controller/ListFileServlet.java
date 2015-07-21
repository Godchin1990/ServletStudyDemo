package cn.lnu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lnu.service.BusinessService;
import cn.lnu.service.impl.BusinessServiceImpl;
//�г����й����ص��ļ�
public class ListFileServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ݿ��л�������ϴ��ڷ��������������ص��ļ�����Ϣ��ÿ����¼��һ�������ļ�������Ϣ
		BusinessService service =new BusinessServiceImpl();
		List list=service.getAllUpfile();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/listfiles.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request,response);
	}

}
