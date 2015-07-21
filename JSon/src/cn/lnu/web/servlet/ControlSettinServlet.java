package cn.lnu.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.lnu.utils.WebUtils;
import cn.lnu.web.formbean.CotrolForm;
//������ƻ�����У��servlet
public class ControlSettinServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���������������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//���ͻ��˴������Ĳ���ת�浽һ��bean������
		CotrolForm control =WebUtils.request2Bean(request, CotrolForm.class);
    	
    	String tcount=request.getParameter("tcount");
    	System.out.println("request="+tcount);
    	
		boolean isCheck;
		try{
			isCheck=control.validate(request);
			if(!isCheck){//ϵͳ����ʧ�ܵ�������ҳ�棬��д���ã������Ѻ���ʾ
				request.setAttribute("control", control);
				//У��ʧ�ܣ���ʧ�ܵ���ʾ��Ϣ�����ص����ý��棬��ʾ�û�
				Map map=control.getErrors();
				JSONObject jsonErrors=JSONObject.fromObject(map);
				String jstrErrors=jsonErrors.toString();
				request.setAttribute("jstrErrors", jstrErrors);
				
				request.getRequestDispatcher("/WEB-INF/jsp/controlSyscfg.jsp").forward(request, response);
				return;
			}
			//У��ɹ�
			try{
				//���û�������Ϣ���浽���ݿ��У���ʱ�Ȳ����ǣ����Ժ���չ������ģ��Ѷ���ת��Ϊjson��ʽ���ַ�������ǰ̨ҳ����ʾ
				JSONObject json = JSONObject.fromObject(control);
				String jstr=json.toString();
				request.setAttribute("jstr", jstr);
			
				//��ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ���óɹ�����Ϣ
				request.setAttribute("message", "��ϲ��,���ƹ�������óɹ���");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("message","����������δ֪����");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
