package cn.lnu.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ʹ��Responseʵ���ļ����غʹ������ļ������ļ�������
public class ResponseDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String path = this.getServletContext().getRealPath("/download/qe.jpg");
		String path = this.getServletContext().getRealPath("/download/����.pdf");
		String filename = path.substring(path.lastIndexOf("\\") + 1);
		//��������ļ��������ļ��������ļ�����Ҫ����url����
		//response.setHeader("content-disposition", "attachment;filename="+ filename);
		response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
		
		//д�ļ����ļ������������
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			out = response.getOutputStream();//��ôд��д�������
			//out=new FileOutputStream("c:/2.jpg");//����д��д���ļ���ȥ��
			while ((len = in.read(buffer)) > 0) {// �����������
				out.write(buffer, 0, len);// ÿ�ζ��Ǵ�buffer�Ŀ�ʼ��len���ֽ�
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
