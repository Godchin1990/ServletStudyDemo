package cn.lnu.web.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lnu.domain.Customer;
import cn.lnu.service.BusinessService;
import cn.lnu.service.impl.BusinessServiceImpl;
import cn.lnu.utils.Globals;
import cn.lnu.utils.WebUtils;


public class EditCustomerServlet extends HttpServlet {
	//����id��ȡ��Ҫ�޸ĵĿͻ���Ϣ
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		BusinessService service=new BusinessServiceImpl();
		Customer c=service.findCustomer(id);//����id�����û�
		
		//����ò��ҵ�Ҫ�޸��û����Ը��޸ĵ�ǰ�û�����
		request.setAttribute("c", c);
		request.setAttribute("genders", Globals.genders);
		request.setAttribute("preferences", Globals.preferences);
		request.setAttribute("types", Globals.types);
		request.getRequestDispatcher("/WEB-INF/jsp/editCustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ύ���ݵ�������������
		request.setCharacterEncoding("UTF-8");
		//����д�ı����޸���Ϣ��װ��customer������
		try{
			String id=request.getParameter("id");
			Customer c=WebUtils.requestToBean(request, Customer.class);
			BusinessService service=new BusinessServiceImpl();
			service.updateCustomer(c);
			request.setAttribute("message", "�����û��ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "�����û�ʧ�ܣ�");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
}
