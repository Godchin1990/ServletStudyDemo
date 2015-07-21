package cn.lnu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.lnu.domain.Upfile;
import cn.lnu.service.BusinessService;
import cn.lnu.service.impl.BusinessServiceImpl;
import cn.lnu.utils.WebUtils;

public class UpfileServlet extends HttpServlet {
	//��ת��jsp,��ʾ�ϴ�ҳ��
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.getRequestDispatcher("/WEB-INF/pages/addfiles.jsp").forward(request, response);
	}
	
	//����post��ʽ�������ϴ��ļ�����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){//��������ļ��ϴ�����
			request.setAttribute("message", "��֧�ֵ��ļ�����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		try{
			String path=this.getServletContext().getRealPath("/WEB-INF/upload");//�ļ����ϴ�Ŀ¼���ܱ�������ֱ�ӷ��ʵ��������������õ�WEB-INF��
			Upfile upfile=WebUtils.doUpload(request,path);
			BusinessService service=new BusinessServiceImpl();
			service.addUpfile(upfile);
			//������������������ϴ�����û���׳��쳣��˵������ɹ�
			request.setAttribute("message", "�ļ��ϴ��ɹ���");
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			request.setAttribute("message", "�ϴ��ļ���С���ܳ���500M.");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "�ļ��ϴ�ʧ�ܣ�");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
