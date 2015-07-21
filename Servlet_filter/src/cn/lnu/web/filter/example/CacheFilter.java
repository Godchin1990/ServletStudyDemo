package cn.lnu.web.filter.example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�������������Ĺ�����
public class CacheFilter implements Filter {
	
	private FilterConfig config;
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		String css=config.getInitParameter("css");
		String js=config.getInitParameter("js");
		//1.��ȡ���û�����ʵ���Դ
		String uri=request.getRequestURI();//�û�����ʵ���Դ������request���л��
		//2����ȡ����Դ�������ļ����õĻ���ʱ�䣬�����ļ������õ�ֵ���Ƿ���Ϊ��λ��
		int expires=0;
		if(uri.endsWith(".bmp")){
			expires=Integer.parseInt(config.getInitParameter("bmp"));
		}else if(uri.endsWith(".css")){
			expires=Integer.parseInt(config.getInitParameter("css"));
		}else{
			expires=Integer.parseInt(config.getInitParameter("js"));
		}
		
		//3,ʹ��response���û���ͷ���ڶ�������ֵ��long�͵ĺ���ֵ,���ʱ��ֵ��Ҫ����1970�꿪ʼ��ʱ�䣬������Ҫ��һ����ǰ��ʱ��ֵ
		response.setDateHeader("Expires", System.currentTimeMillis()+expires*60*1000);
		//4������,��ôһ��Ŀ����Դ�õ��Ķ������ú�responseͷ��response��ʹ�����respose���ʱ�����ݶ��ᰴָ�������ļ�ʱ��ֵ����
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//��סweb.xml��Ϊ�ù��������õĲ���
		this.config=filterConfig;
	}

}
