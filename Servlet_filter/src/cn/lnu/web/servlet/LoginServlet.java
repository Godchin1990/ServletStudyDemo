package cn.lnu.web.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
import cn.lnu.domain.User;
import cn.lnu.service.BusinessService;
//�����¼�����servlet
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//�õ�һ���û�����֮�󣬴���һ��service����ȥ��������
		BusinessService service=new BusinessService();
		User user=service.login(username, password);//������ݿ��д�������û����������򷵻�����û�
		if(user==null){//��¼ʧ��
			request.setAttribute("message", "�û��������벻��ȷ����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//�����������û�����¼�ɹ���session�д��һ����¼��ǣ�����ʵ���û��Զ���¼���ڵ�¼�ɹ�֮��Ҫ���ͻ��˷�cookie��
		//�����û��ĵ�¼����Ϣ���´��û��ٴε�¼ʱ������ŵ�¼��Ϣ��cookie���������cookie��Ϊ�գ�����cookie�������Զ���¼
		request.getSession().setAttribute("user", user);
		//���ǰ̨ҳ�����õ���Ч��
		int expirestime=Integer.parseInt(request.getParameter("time"));
		//���ͻ��������Զ���¼��cookie,cokie����Ϊautologin
		//autologin=username:expirestime:md5(password:expirestime:username),����cookie��ֵ��md5��ֹ���뱻�����ƽ�
		Cookie cookie=makeCookie(user,expirestime);
		response.addCookie(cookie);//��cookie���ظ��ͻ��������������������´η���վ���µ���Դʱ�ͻ�������cookie����
		//��¼�ɹ�֮���ض�����ҳ�������û���¼�ɹ�
		response.sendRedirect("/Servlet_filter/index.jsp");
	}

	//�Զ��庯��������һ��cookie
	public Cookie makeCookie(User user,int expirestime){
		long currenttime=System.currentTimeMillis();
		//������cookie��ֵ
		String cookieValue=user.getUsername()+":"+(currenttime+expirestime*1000)+":"+md5(user.getUsername(),user.getPassword(),(currenttime+expirestime*1000));
		Cookie cookie=new Cookie("autologin",cookieValue);
		cookie.setMaxAge(expirestime);//����cookie�����Ч��
		cookie.setPath("/Servlet_filter");//�������cookie�����������������/Servlet_filter���վ���µ�������Դʱ�����Ÿ�cookie����
		
		return cookie;
	}
	//���û��������cookie��Ч������md5�£���ֹ���뱻�˱����ƽ�
	private String md5(String username,String password,long expirestime){
		String value=password+":"+expirestime+":"+username;
		//ʹ��MessageDigest��һ���ַ���md5
		try {
			MessageDigest md=MessageDigest.getInstance("md5");// ����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
			byte md5[]=md.digest(value.getBytes());
			//ʹ��BASE64��md5����
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(md5);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
