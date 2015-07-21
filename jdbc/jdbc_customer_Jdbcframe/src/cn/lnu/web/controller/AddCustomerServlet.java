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
//���servlet�ȿ���Ϊ�û��ṩ��ͼ���棬Ҳ���Դ�����ͼ�����post����
public class AddCustomerServlet extends HttpServlet {
	
	//���û��ṩһ������û���ͼ����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("genders", Globals.genders);
		request.setAttribute("preferences", Globals.preferences);
		request.setAttribute("types", Globals.types);
		request.getRequestDispatcher("/WEB-INF/jsp/addcustomer.jsp").forward(request, response);
	}
	
	//�����û���addcustomer.jspҳ�����ӿͻ���post�������������post���󣬷������ת��doGet����ִ����ش���
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
			String preference=request.getParameter("preference");
			//System.out.print(preference);
			//��������ύ�Ĳ���֮��,��Ҫ�Ա�����У�飬�ṩһ��formbean�����ݷ�װ��У�飬������ʱ��У��
			
			//�����ݷ�װ��customer����,�����ڹ��߰����ڴ���һ��WebUtils������һ��ȡ�������ݣ�
			Customer c=WebUtils.requestToBean(request, Customer.class);
			//�����ݿ�������û�����ҪΪ�û�����һ��id
			c.setId(WebUtils.generateID());
			
			//����service�ӿ�Ϊweb������û������ṩ֧��,�����û���ӵ����ݿ���ȥ
			BusinessService service=new BusinessServiceImpl();
			service.addCustomer(c);
			request.setAttribute("message", "����û��ɹ���");	
		}catch(Exception e){
			e.printStackTrace();//��������������쳣�ˣ���̨��¼����쳣������ת����Ϣ��ʾҳ�棬���û��Ѻ���ʾ
			request.setAttribute("message", "����û�ʧ�ܣ�");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
}
