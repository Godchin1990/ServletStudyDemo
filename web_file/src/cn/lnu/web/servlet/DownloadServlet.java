package cn.lnu.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�����ļ�����ҳ������������servlet
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");//���ַ�ʽֻ�ܽ��post��ʽ�ύ���������ݵ������������⣬������ͨ��������get��ʽ�ύ�Ĺ����ģ��������ñ�����Ч�������ֹ�ת��
		String filename=request.getParameter("filename");
		//�ֶ����get��ʽ��õĲ��������������⣬
		filename=new String(filename.getBytes("iso8859-1"),"UTF-8");
		
		//�����ļ�������λ��������������ļ�����Ŀ¼(֮ǰ�ϴ����ļ��ı���Ŀ¼����hash�������õ��ļ������ڷ������˵�Ŀ¼)
		String path=this.getServletContext().getRealPath("/WEB-INF/upload")+File.separator+getFilePath(filename);
		
		//�ڶ��������е�����ļ�֮ǰ�������ж�һ������ļ��Ƿ��ڷ��������Ŀ¼��
		File file=new File(path+File.separator+filename);
		if(!file.exists()){//����ļ�������
			request.setAttribute("message", "�Բ���,�����ļ������ڣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//�õ��ļ���ԭʼ�ļ���
		//String oldname=file.getName().substring(file.getName().lastIndexOf("_")+1);
		String oldname=filename.substring(filename.indexOf("_")+1);
		//�ļ����ڣ���ʼ���ļ�������������ڴ�֮ǰ֪ͨ����������ط�ʽ�����з��͵�����(������һ��ͷ,֪ͨ����������ط�ʽ��)
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(oldname,"UTF-8"));
		FileInputStream in=new FileInputStream(file);
		//FileOutputStream out=new FileOutputStream("c:\\"+filename);//д��Ӳ��
		OutputStream out=response.getOutputStream();//��ȡд��������������
		int len=0;
		byte buffer[]=new byte[1024];
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		
		in.close();
	}

	public String getFilePath(String filename){
		int hashcode=filename.hashCode();//�õ��ļ�������ַ����������ڴ��еĵ�ַ32λϵͳ����һ���ĸ��ֽڵ�����
		int dir1=hashcode&0xf;//�û��ļ�����ϣֵ�ĺ���λ��һ���ļ�Ŀ¼
		int dir2=(hashcode>>4)&0xf;//�û��ļ�����ϣֵ������λ��ȥ����λ�������ļ�����Ŀ¼
		return dir1+File.separator+dir2; //���ص��������� 3/5�������ļ�·��
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
