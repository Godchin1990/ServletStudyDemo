package cn.lnu.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String data="bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		String data="�й����";
		//�����ݷ��������
		//response.getOutputStream().write(data.getBytes("UTF-8"));
		response.getWriter().write(data);//PrintWriter.Write("�й�")��------��ByteArrayOutputStreamʱ�Ὣ����д���ײ㻺���ֽ��������ǻ�Ĭ�ϲ�GB2312���,�ͻ����������
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
