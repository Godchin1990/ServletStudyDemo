package cn.lnu.web.filter.example;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import cn.lnu.domain.User;
import cn.lnu.service.BusinessService;
//�����û����������󣬼���û������Ƿ��cookie��������������ˣ��͸���cookie��Ϣ���û��Զ���¼�����û�д�cookieֱ�ӷ���
public class AutoLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		//1������û���û���Ѿ���¼(���session����û�д��¼���)��û��¼���Զ���¼
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null){//����Ѿ���¼��ֱ�ӷ���
			chain.doFilter(request, response);
			return;
		}
		//2,û��½����ִ���Զ���¼�߼�
		
		//���û���û�д��Զ���¼��cookie
		Cookie autoLoginCookie=null;//�û������ҵ����Զ���¼��cookie
		Cookie cookies[]=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("autologin")){
				autoLoginCookie=cookies[i];
				break;
			}
		}
		
		if(autoLoginCookie==null){//��ʾ���û���һ�ε�¼,˵��û���Զ���¼cookie��ֱ�ӷ���
			chain.doFilter(request, response);
			return;
		}
		
		//�û������Զ���¼cookie�����ȼ��cookie��Ч�ڵ���Ч��
		String values[]=autoLoginCookie.getValue().split("\\:");
		if(values.length!=3){
			chain.doFilter(request, response);
			return;
		}
		long expirestime=Long.parseLong(values[1]);
		if(System.currentTimeMillis()>expirestime){
			chain.doFilter(request, response);
			return;
		}
		//,����cookie����Ч������Ч�ģ��ټ��cookie�������Ч��
		String username=values[0];
		String client_md5=values[2];
		
		BusinessService service=new BusinessService();
		user=service.findUser(username);
		if(user==null){
			chain.doFilter(request, response);
			return;
		}
		
		String password=user.getPassword();
		//���û���������,cookie��Ч����ϳ�md5(password:expirestime:username)��ʽ
		String server_md5=md5(username,password,expirestime);
		//����������˺Ϳͻ��˵Ĵ�������Ϣ��md5��
		if(!server_md5.equalsIgnoreCase(client_md5)){//����ͻ�����������˴�������Ϣ��md5�벻ƥ��ͷ���
			chain.doFilter(request, response);
			return;
		}
		//���ִ�е�¼����session�д��һ����¼��ǣ�Ȼ�����
		request.getSession().setAttribute("user", user);
		chain.doFilter(request, response);
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
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
