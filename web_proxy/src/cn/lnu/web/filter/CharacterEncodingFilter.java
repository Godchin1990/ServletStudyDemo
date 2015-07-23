package cn.lnu.web.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���������У�ʹ�ö�̬���������ȫվ��������
public class CharacterEncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		final HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		request.setCharacterEncoding("UTF-8");//���ַ���ֻ�ܽ��post��ʽ�ύ�������������ݵ������������⣬���ܽ��get��ʽ�������������⣬��get��ʽ�ύ������ʹ��request.getParameter(name)����������ݻ��ǻ��������룬
		//��request��������getParameter(name)�����Ĺ��ܲ���ǿ,����ʹ�ô����request�����getParameter����������ǿ������ֻ����get��ʽ����ǿ����������ܣ�
		
		//��request�Ĵ�����У�ʵ�ֽ��ȫվ�����������⣬�����servlet�õ��Ķ���requestProxy,���õĺ�����ͨ�����������õġ�����˵requestProxy.getCookie,requestProxy.getParameter
		chain.doFilter((ServletRequest) Proxy.newProxyInstance(CharacterEncodingFilter.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if(!method.getName().equals("getParameter")){//�������servlet���õĲ���getParameter�������򲻽�����ǿ������ʹ��ԭ����request������
					return method.invoke(request, args);//	InvocationHandler���ڲ�ʵ���࣬����requestҪ����Ϊfinal����
				}
				
				//��������õ���getParameter�������ж��ǲ���get��ʽ�ύ����������
				if(!request.getMethod().equalsIgnoreCase("get")){//�������get��ʽ�ύ�����ݣ�������ǿ������ʹ��ԭ����request������ע��getMethod�������Կ��Ի��ǰ̨�ύ���ݵķ�ʽ��get����post
					return method.invoke(request, args);
				}
				
				//���servlet���õ���getParameter�����������Ǵ����һget��ʽ�ύ���������ݣ���ʱ��Ҫ��getParameter����������ǿ
				String value=(String) method.invoke(request, args);//����ʹ��ԭʼ��getParameter�ĺ������ǰ̨�ύ�����Ŀ��������������ֵ
				//Ȼ�����ֵ������ת����
				if(value==null){
					return null;
				}
				
				return new String(value.getBytes("iso8859-1"),"UTF-8");
			}
			
		}), response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
