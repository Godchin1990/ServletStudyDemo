package cn.lnu.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���������վ��ҳ��ģ��ʹ��cookie������ʾ�û��ϴη���ʱ��
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.print("<a href='/TestServletHTTP_Cookie_Session/servlet/CookieDemo2'>ɾ���ϴη���ʱ��:</a><br/>");
		out.print("�𾴵��û�������ϴη���ʱ���ǣ�");
		
		//����û���ʱ��cookie
		Cookie cookies[]=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("lastAccessTime")){
				long cookieValue=Long.parseLong(cookies[i].getValue());//�õ��û��ϴη��ʵ�ʱ��cookieֵ(Ĭ�Ϻ���ֵ),������ת��Ϊʱ��ֵ
				Date date=new Date(cookieValue); 
				out.print(date.toLocaleString());
			}
		}
		//���û�����������µķ���ʱ��
		Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//����cookie��Ч��
		cookie.setMaxAge(1*30*24*3600);
		//����cookie����Ч·������ʾ����ʲô·���µ�web��Դ�������cookie����
		cookie.setPath("/TestServletHTTP_Cookie_Session");//�������õ�·����ʾ��ϣ�����û�������վ��TestServletHTTP_Cookie_Session���Ŀ¼�µ���Դʱ�������cookie����
		
		//��cookieд�������
		response.addCookie(cookie);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
