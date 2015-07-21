package cn.lnu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.lnu.domain.Bls;
import cn.lnu.service.BusinessService;
import cn.lnu.service.impl.BusinessServiceImpl;
//���������������servlet
public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id=request.getParameter("id");
		//System.out.print(id);
		if(id==null||id.trim().equals("")){
			request.setAttribute("message", "�봫����ȷ�Ĳ����룡");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		BusinessService service=new BusinessServiceImpl();
		
		Object bean=null;
		JSONObject json=null;
		String jstr;
		if (id.length() == 2 && id.trim().startsWith("0")) {//������
			bean = service.find(id);	
		} else if (id.length() == 2 && id.trim().startsWith("1")) {//���鸴��
			bean = service.find1(id);
		}else if(id.length()==3 && id.trim().startsWith("01")){//��������֧��
			bean=service.find2(id);
		}else if(id.length()==3 && id.trim().startsWith("02")){//��������֧��ѵ��
			bean=service.find3(id);
		}else if(id.length()==3 && id.trim().startsWith("03")){//��������֧��ģ�⿼��ѵ��
		
		}else if(id.length()==3 && id.trim().startsWith("04")){//��������֧�ֿ���
			bean=service.find4(id);
		}else if(id.length()==4 && id.trim().startsWith("042")){//��������֧�ֿ���
			bean=service.find5(id);
		}else if(id.length()==4 && id.trim().startsWith("043")){//��������֧�ֿ���
			bean=service.find6(id);
		}else if(id.length()==4 && id.trim().startsWith("044")){//��������֧�ֿ���
			bean=service.find7(id);
		}else if(!id.trim().startsWith("0")){
			id="{btnid:'"+id+"',";
			id+="btnname:"+"'��������֧�ֽ�ѧ',";
			id+="id:"+"'01'}";
			System.out.println("Mainface "+id);
			this.getServletContext().setAttribute("bean", id);
			response.sendRedirect("/JSonDemo/servlet/ScreenServlet?id=10000");
		}
		
		if(bean!=null){
			json = JSONObject.fromObject(bean);
			jstr= json.toString();
			System.out.print("Mainface "+jstr);
			this.getServletContext().setAttribute("bean", bean);
			//response.getOutputStream().write(jstr.getBytes("UTF-8"));
			response.sendRedirect("/JSonDemo/servlet/ScreenServlet?id=10000");
			//request.getRequestDispatcher("/servlet/ScreenServlet").forward(request,response);
		}
		
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
