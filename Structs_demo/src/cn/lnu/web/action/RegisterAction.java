package cn.lnu.web.action;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import cn.lnu.web.formbean.RegisterBean;

public class RegisterAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		//������ظ��ύ
		if(!this.isTokenValid(request)){
			System.out.println("���ظ��ύ����");
			return null;
		}
		
		//������ύ������ǰ��ɾ�������������
		this.resetToken(request);
		
		//�����ļ��ϴ�
		RegisterBean registerForm=(RegisterBean) form;
		FormFile file=registerForm.getFile();
		String filename=file.getFileName();//����ϴ��ļ���
		InputStream in=file.getInputStream();//����ϴ��ļ��������������Ϳ��Զ���
		int len=0;
		byte buffer[]=new byte[1024];
		
		FileOutputStream out=new FileOutputStream("c:\\"+filename);//���ϴ��ļ�д������
		while((len=in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		in.close();
		out.close();
		System.out.println("������ύ����");
		return null;
		/*RegisterBean registerForm=(RegisterBean) form;
		String username=registerForm.getUsername();
		String password=registerForm.getPassword();
		String email=registerForm.getEmail();
		try{
			System.out.println("�����ݿ���ע�� "+username+" �û�");
			request.setAttribute("message", "ע��ɹ�");
		}catch(Exception e){
			request.setAttribute("message", "ע��ʧ��");
		}
		//������ת
		//request.getRequestDispatcher("/message.jsp").forward(request, response);//�ǿ�ܴ�ͳ��תҳ�淽ʽ
		//ʹ��structs�ṩ����ת��ʽ
		//ActionForward forward=new ActionForward("/message.jsp");
		//Ϊ�˲�д������������structs�������ļ������õ������actionʱҪ��ת��ҳ��·��
		return mapping.findForward("message");*/
	}
	
}
