package cn.lnu;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//test servletConfig��Ϣ
//servletConfig�������ڷ�סservlet��������Ϣ
//��ʵ�ʿ����У���һЩ�������ʺ���servlet������д�����������ݿ���ͨ�����÷������servlet�����磺
//servlet�����ĸ��ַ������servlet�����ĸ����ݿ⣬servletʹ���ĸ������ļ�
public class ServletDemo2 extends HttpServlet {
	//private ServletConfig config;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*ServletConfig config=this.getServletConfig();
		//���ָ��������ֵ
		String value=config.getInitParameter("data1");//Ҫ��ò���ֵ����Ҫ�������ļ��еĲ��������ݽ�ȥ
		System.out.println(value);*/
		//������в�����Ϣ
		Enumeration e = this.getServletConfig().getInitParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String value=this.getServletConfig().getInitParameter(name);
			System.out.println(name+" "+value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	//Ҫ����web.xml��Ϊservletд��������Ϣ��ֻ��Ҫ����init�������������Զ�����Щ������Ϣ��װ��һ��servletConfig������ȥ��
	//�����ڵ���servlet����init����ʱ���Զ������servletConfig���󴫵���������У����ǿ���ͨ�������������ص�������Ϣ
	/*@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.config=config;//���config������Ϣ
	}*/
	
}
