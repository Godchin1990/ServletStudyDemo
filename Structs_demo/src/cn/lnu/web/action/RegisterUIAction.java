package cn.lnu.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterUIAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����һ��������浽request����
		saveToken(request);//��������ڲ�ʵ�־��ǲ���һ����������浽һ�����У�struts�ṩ�˺�������������֮ǰ���ÿ��ʱ�������Լ�����������������
		
		//����������浽request��֮����ת��jspҳ�棬�����������ȥ��
		//request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		//�������ַ�ʽ�ǲ�ʹ�ÿ��ʱ��ҳ����ת��ʽ������Ϊ��ʹ��struts�����ת��ʽ������ҪΪRegisterUIAction���action��struts-config.xml��Ϊ������һ��forward����������ת��ַ
		//��ת��һ����ͼ
		return mapping.findForward("registerUI");
	}
	
}
