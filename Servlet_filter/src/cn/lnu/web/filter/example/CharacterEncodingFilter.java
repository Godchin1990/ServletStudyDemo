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
//���ȫվ����
public class CharacterEncodingFilter implements Filter {
	
	private FilterConfig config;
	private String defaultCharset = "UTF-8";

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// ��ȡҪ���õ��ַ���
		String charset=config.getInitParameter("charset");
		if(charset==null){//Ϊ�������������ַ���������Ĭ���ַ���
			charset=defaultCharset;
		}
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config=filterConfig;//����������ʱ����������ļ��жԹ�������������Ϣ������config�����ס�����ö�����Ϣ
		System.out.println("������");
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}

}
