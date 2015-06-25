package cn.lnu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//����session
public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		//�ڵõ�session�����ͬʱ��������Ϊsession���󴴽���session id����cookie�ķ�ʽд�ظ����������������һ��cookie����Ч��Ϊ30�죬
		//�����Ļ����Ͳ������֮ǰ������session�������ͻȻ����;�رգ��ٴδ��Ҳ���ԭ��session�����״���������´���session
		String sessionid=session.getId();
		Cookie cookie=new Cookie("JSESSIONID",sessionid);
		cookie.setPath("/TestServletHTTP_Cookie_Session");
		cookie.setMaxAge(1*30*24*3600);
		response.addCookie(cookie);
		
		session.setAttribute("name","�ʼǱ�");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
