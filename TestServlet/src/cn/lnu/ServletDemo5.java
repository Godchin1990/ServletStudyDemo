package cn.lnu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
  servletContext��
  1��˵������һ������
  2��servletContext����仰˵��������������÷�Χ��Ҳ����Ӧ�ó������÷�Χ
 */
//���Ի�ô�servletDemo4��д�뵽TestServlet�����webӦ�õĹ�����Դ��ʵ��servletDemo4��servletDemo5�����ݹ���
public class ServletDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value=(String)this.getServletContext().getAttribute("data");
		System.out.print(value);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
