package cn.lnu.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ͨ��response��PrintWriter��(ֻ��д�ַ������ַ�)��ͻ�������ַ�������
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(response);
		test2(response);
	}

	private void test1(HttpServletResponse response) throws IOException {
		//����Response����ʹ�õ�����Կ���response������ʲô����������д������
		response.setCharacterEncoding("UTF-8");
		//��Ȼ��������Response�������UTF-8,��ôҪ��ͻ�����������������ʾ����Ҫͨ��������Ӧͷ������������õ����ҲΪUTF-8����ʾ���������͵�����,��Ҫ����һ��
		response.setHeader("content-type", "text/html;charset=UTF-8");
		String data="�й�";
		PrintWriter out=response.getWriter();
		out.write(data);//ֱ����ôд���������ʱ���᷵������??����Ϊ����д��resonse�ģ���responseһ����õ���ISO8859��������Ҫ����response�����
	}

	private void test2(HttpServletResponse response) throws IOException {
		//����Response����ʹ�õ�����Կ���response������ʲô����������д������
		//response.setCharacterEncoding("UTF-8");
		//Ҫָ���������ʲô���򿪷��������͵�����Ҳ����ʹ���������ַ������������ʹ��ʲô����,���Ҹ�ǿ���������������response���õ����ҲΪUTF-8
		//response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String data="�й�";
		PrintWriter out=response.getWriter();
		out.write(data);//ֱ����ôд���������ʱ���᷵������??����Ϊ����д��resonse�ģ���responseһ����õ���ISO8859��������Ҫ����response�����
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
