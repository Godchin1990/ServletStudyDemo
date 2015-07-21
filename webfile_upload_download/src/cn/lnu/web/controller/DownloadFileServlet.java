package cn.lnu.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lnu.domain.Upfile;
import cn.lnu.service.BusinessService;
import cn.lnu.service.impl.BusinessServiceImpl;
//�����ļ���������
public class DownloadFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ͨ��ǰ̨�����Ӵ������������ļ���id���ڷ������ҵ�Ҫ�����ļ���Ϣ
		String id=request.getParameter("id");
		BusinessService service=new BusinessServiceImpl();
		Upfile upfile=service.finUpfile(id);
		File file=new File(upfile.getSavepath()+"\\"+upfile.getUuidname());
		if(!file.exists()){
			request.setAttribute("messsage", "�Բ��������ص��ļ������ڣ������ѱ�ɾ����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//�ӷ���������Ŀ¼�£������ļ�
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(upfile.getRealname(),"UTF-8"));//��������������صķ�ʽ��
		//FileInputStream in=new FileInputStream(upfile.getSavepath()+"\\"+upfile.getUuidname());//��Ҫ�����Ͷ��ļ��������ж��ļ��ڷ��������Ƿ����
		FileInputStream in=new FileInputStream(file);
		int len=0;
		byte buffer[]=new byte[1024];
		OutputStream out=response.getOutputStream();//д�������
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
