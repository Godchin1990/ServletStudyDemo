package cn.lnu.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ɾ��cookie
public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ɾ��ĳһ��cookie����new����cookie�����ֱ��뱣��һ��
		Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(0);
		//ɾ��cookieʱ�����ɾ��cookie֮ǰ������path����ɾ��cookieҲҪ������ͬ��path
		cookie.setPath("/TestServletHTTP_Cookie_Session");
		response.addCookie(cookie);
		//ɾ��֮�������ض���ԭ��ҳ��
		response.sendRedirect("/TestServletHTTP_Cookie_Session/servlet/CookieDemo1");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
