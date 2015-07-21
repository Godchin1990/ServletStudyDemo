package cn.lnu.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�����ļ��ϴ���servlet
public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���������Ϊenctype="multipart/form-data"�Ļ�����servlet��ע��Ͳ���ʹ�ô�ͳ��ʽ���ǰ̨��������
		/*String username=request.getParameter("username");
		System.out.println(username);*/
		//�����ļ��ϴ�ʱ������ʱ����mime��������������ʱҪ���ں�̨���ǰ̨ҳ���ύ���������ݣ��ͱ���ʹ�û�ȡ�����ķ�ʽ���
		InputStream in=request.getInputStream();//��ǰ̨���������ķ�ʽ��ȡ��Ȼ�󷵻�һ������ǰ̨�ύ���ݵ�������,��ֻ̨�ܲ�ȡ�����������ķ�ʽ��ȡǰ̨����
		OutputStream out=null;
		try{
			int len=0;
			byte buffer[]=new byte[1024];
			while((len=in.read(buffer))>0){
				System.out.println(new String(buffer,0,len));//����������ÿ���ֵ�����������
				//out.write(buffer, 0, len);
			}
		}finally{
			if(in!=null){
				in.close();
			}
			if(out!=null){
				out.close();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
