package cn.lnu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���������ڷ���֮ǰ��Ҫ��ǿrequest��getParameter���������˴ʸ������ݻ����滻���滻֮�������
		String data=request.getParameter("resume");
		//����һ�ѷ�����ǹ����Ҫ�缦��****�𣿣���ǿ֮��Ľ���ǣ�������ǹ�͵缦����˴ʸ����ɺ�ɫ���Ĵ󽢶��滻�ʣ��滻��****
		response.getWriter().write(data);//д�����������Ч��,��servletDemo1���ҳ�濴Ч���������������һ�ѷ�����ǹ����Ҫ�缦��,���������ǹ�͵缦�͸����ɺ�ɫ�ˣ�Ȼ�󽻸�����Աȥ���
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
