package cn.lnu.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(response);
		//test2(response);
		//test3(response);
		test4(response);
	}
	//��servlet����OutputStream(�ֽ���)��ͻ�������������������
	private void test1(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		//�����������ʲô�����ʾ���������ص�����,Ҳ��servlet������ʲô�������ˣ������һ��Ҫ�����������ʲô������ʾ
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		//�����������й���������
		String data="�й�";
		OutputStream out=response.getOutputStream();
		out.write(data.getBytes("UTF-8"));//���ֽ�������ʹ��UTF-8���ķ�ʽ���ظ������
	}
	
	private void test2(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		// �����������й���������
		String data = "�й�";
		OutputStream out = response.getOutputStream();
		//html�� <meta>��ǩ��http-equiv����ģ��һ��HTTP��Ӧͷ(����ģ���ĸ�ͷ��http-equivָ��)�������������ʾ���ݲ���ʲô���
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
		out.write(data.getBytes("UTF-8"));
	}
	
	//��servlet����OutputStream����������������
	private void test3(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		//ע�⣬����д���ˣ����������ʾ����
		response.setHeader("content-type", "text/html,charset=UTF-8");
		
		//�����������й���������
		String data="�й�";
		OutputStream out=response.getOutputStream();
		out.write(data.getBytes("UTF-8"));//���ֽ�������ʹ��UTF-8���ķ�ʽ���ظ������
	}
	
	//��servlet����OutputStream���������ʾȴ�������ֵ�����
	private void test4(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		OutputStream out=response.getOutputStream();
		//out.write(1);
		//��Ҫ������1ת��Ϊ�ַ�������ת��Ϊ�ֽ���д��
		out.write((1+"").getBytes());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
