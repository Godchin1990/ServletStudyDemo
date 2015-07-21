package cn.lnu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lnu.domain.User;
import cn.lnu.exception.UserExistException;
import cn.lnu.service.impl.BusinessServiceImpl;
import cn.lnu.utils.WebUtils;
import cn.lnu.web.formbean.RegisterForm;
//����ע������
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//Ϊ�˷�ֹ�ӱ������֤�벻�����룬�����ǳ�Ҳ������ȷƥ��
			request.setCharacterEncoding("UTF-8");
			
			//1.�Ա��ύ�ֶν��кϷ���У�飨�ѱ����ݷ�װ��formbean��
			RegisterForm bean=WebUtils.request2Bean(request,RegisterForm.class);
			boolean b;
			try {
				b = bean.validate(request);
				//2.У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
				if(!b){
					//��������ϢҲ����ע��ҳ�棬���ڸ��û��Ѻ���ʾ
					request.setAttribute("bean", bean);
					request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
					return;
				}
				
				//3.���У��ɹ��������service�㴦��ע������
				//�����е��������ϵ�user��
				User user=new User();
				WebUtils.copyBean(bean, user);
				//Ϊ�û�����һ��ȫ��Ψһid
				user.setId(WebUtils.generateID());
				
				BusinessServiceImpl service=new BusinessServiceImpl();
				try{
				service.register(user);//���û�ע�ᵽ���ݿ���
				//6. ���service����ɹ�������ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾע��ɹ�����Ϣ
				request.setAttribute("message", "��ϲ��ע��ɹ���");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
				}catch(UserExistException e){
					//4.���service�����ɹ������Ҳ��ɹ���ԭ����ע���û��Ѿ����ڣ������ص�ע��ҳ�棬��ʾע���û��Ѵ���
					bean.getErrors().put("username", "ע���û����Ѵ���!");
					request.setAttribute("bean", bean);
					request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
					return;
				}catch(Exception e){
					//5,���service�����ɹ������Ҳ��ɹ���ԭ������������Ļ�������ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ�Ѻô�����Ϣ
					e.printStackTrace();
					request.setAttribute("message","����������δ֪����");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
