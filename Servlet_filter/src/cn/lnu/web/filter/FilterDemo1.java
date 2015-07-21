package cn.lnu.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {

	/*������filter�ڿ����г���Ӧ��
	 * 1��filter��Ŀ����Դ��ִ��֮ǰ������һЩȨ�޼�飬����û�����Ȩ�ޣ�����Ȩ������У���û����ܾ�����
	 * 2��filter�����ڷ�����Դִ��֮ǰ����request��response����Ԥ�����Ӷ�ʵ��һЩȫ���Ե�����(������վ������������)
	 * 3��filter�ڷ���֮����Բ���Ŀ����Դ�����������response�У����Ӷ����������������ѹ������������
	 * */
	private FilterConfig config;//��ס��ʼ��������Ϣ
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//�ڹ������н���������������⣬����ù�������������վ������Դ����ô��ô���õĻ��ͽ����ȫ��վ��������������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//ʹ�ó�ʼ������
		Enumeration e=config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name=(String) e.nextElement();
			System.out.println(name+" = "+config.getInitParameter(name));
		}
		
		
		System.out.println("FilterDemo1֮ǰ");
		
		//����֮�����Ҫ���������Դ
		chain.doFilter(request, response);
		
		//ѹ������
		
		System.out.println("FilterDemo1֮��");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter1��������");
		this.config=filterConfig;
		Enumeration e=filterConfig.getInitParameterNames();
		while(e.hasMoreElements()){
			String name=(String) e.nextElement();
			System.out.println(name+" = "+filterConfig.getInitParameter(name));
		}
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Filter1�����٣�");
	}
}
