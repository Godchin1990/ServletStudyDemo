package cn.lnu.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ѹ�����
public class ServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		ByteArrayOutputStream bout=new ByteArrayOutputStream();//����һ��������
		//ʵ�������ѹ��֮�󷵻ظ������
		GZIPOutputStream gout=new GZIPOutputStream(bout);//������ָ��ѹ��֮��д��ʲô�ط�ȥ,һ���һ���������Ŀ�꣬������д��������ȥ
		gout.write(data.getBytes());//�ײ���ǽ�����ѹ��֮��д��һ��ByteArrayOutputStream��������ȥ
		gout.close();//ȷ������ȫ��д���������У�����GZIPOutputStream���������ûд������Ҳд����������ȥ
		
		byte gzip[]=bout.toByteArray();//�õ�ѹ������������飬Ȼ���������
		
		//ѹ�����ݴ�������֮ǰ��֪ͨ���������������ʹ�õ�ѹ�������ʽ��ѹ�����ݳ��ȣ�ͨ����ͷ�ķ�ʽ֪ͨ�����
		response.setHeader("content-encoding", "gzip");//����������������˲��õ�ѹ����ʽ
		response.setHeader("content-length", gzip.length+"");//������������ص�ѹ��֮������ݵĳ���
		//�����ݷ��������
		response.getOutputStream().write(gzip);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
