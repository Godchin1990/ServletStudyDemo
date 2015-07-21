package cn.lnu.web.filter.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
//�������ȫվ����
public class CharacterEncodingFilter2 implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		//����������ֻ�ǽ����post����������������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//ͨ��д��װ��ʵ�ֶ�request����ǿ����ͽ����get����ʽ�������������⣬������get��post����ʽ��������������Ͷ������
		chain.doFilter(new MyRequest(request), response);//���ַ�ʽ����request.getParameter(��password��)�����������password������ʽ���������������ģ�����������ݻ�õ�����
	}

	/*��װ���ģʽ�岿��������������Ҫ��ǿrequest����
	 *1�� дһ���࣬ʵ���뱻��ǿ������ͬ�Ľӿ�
	 *2������һ����������ס����ǿ����
	 *3������һ�����췽�������ܱ���ǿ����
	 *4����������ǿ�ķ���
	 *5�����ڲ�����ǿ�ķ�����ֱ�ӵ��ñ���ǿ����Ŀ����󣩵ķ���
	 */
	
	//ʹ��sun��˾Ĭ�ϵ�һ��HttpServletRequestWrapper��װ�࣬����ֻ��Ҫ������Ҫ���ǵķ������ɣ����Ĭ�ϵİ�װ���ڲ��Ƕ�HttpServletRequest����ǿ
	class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request){
			super(request);
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			
			String value=request.getParameter(name);
			if(!request.getMethod().equalsIgnoreCase("get")){
				return value;
			}
			
			if(value==null){
				return null;
			}
			
			try {
				return value=new String(value.getBytes("iso8859-1"),request.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
			
		}
		
		
	}
	
	/*class MyRequest implements HttpServletRequest{
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request){
			this.request=request;
		}
		//Ϊ�˷�ֹ�ͻ��˲���get������ȡ���ݵ��������⣬������Ҫ��ǿ�������
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			String value=request.getParameter(name);
			
			//�жϿͻ��˵�����ʽ�ǲ���get,�������get��������û��Ҫ������ǿ
			if(!request.getMethod().equalsIgnoreCase("get")){
				return value;
			}
			//�����get����value�����������ʽ
			if(value==null){
				return null;
			}
			
			try {//�����������valueת��Ϊ����ʱ���õı��뷽ʽ����
				return value=new String(value.getBytes("iso8859-1"),request.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		
		public String getAuthType() {
			// TODO Auto-generated method stub
			return this.request.getAuthType();
		}
		
		public String getContextPath() {
			// TODO Auto-generated method stub
			return this.request.getContextPath();
		}
		public Cookie[] getCookies() {
			// TODO Auto-generated method stub
			return this.request.getCookies();
		}
		public long getDateHeader(String name) {
			// TODO Auto-generated method stub
			return this.request.getDateHeader(name);
		}
		public String getHeader(String name) {
			// TODO Auto-generated method stub
			return this.request.getHeader(name);
		}
		public Enumeration getHeaderNames() {
			// TODO Auto-generated method stub
			return this.request.getHeaderNames();
		}
		public Enumeration getHeaders(String name) {
			// TODO Auto-generated method stub
			return this.request.getHeaders(name);
		}
		public int getIntHeader(String name) {
			// TODO Auto-generated method stub
			return this.request.getIntHeader(name);
		}
		public String getMethod() {
			// TODO Auto-generated method stub
			return this.request.getMethod();
		}
		public String getPathInfo() {
			// TODO Auto-generated method stub
			return this.request.getPathInfo();
		}
		public String getPathTranslated() {
			// TODO Auto-generated method stub
			return this.request.getPathTranslated();
		}
		public String getQueryString() {
			// TODO Auto-generated method stub
			return this.request.getQueryString();
		}
		public String getRemoteUser() {
			// TODO Auto-generated method stub
			return this.request.getRemoteUser();
		}
		public String getRequestURI() {
			// TODO Auto-generated method stub
			return this.request.getRequestURI();
		}
		public StringBuffer getRequestURL() {
			// TODO Auto-generated method stub
			return this.request.getRequestURL();
		}
		public String getRequestedSessionId() {
			// TODO Auto-generated method stub
			return this.request.getRequestedSessionId();
		}
		public String getServletPath() {
			// TODO Auto-generated method stub
			return this.request.getServletPath();
		}
		public HttpSession getSession() {
			// TODO Auto-generated method stub
			return this.request.getSession();
		}
		public HttpSession getSession(boolean create) {
			// TODO Auto-generated method stub
			return this.request.getSession(create);
		}
		public Principal getUserPrincipal() {
			// TODO Auto-generated method stub
			return this.request.getUserPrincipal();
		}
		public boolean isRequestedSessionIdFromCookie() {
			// TODO Auto-generated method stub
			return this.request.isRequestedSessionIdFromCookie();
		}
		public boolean isRequestedSessionIdFromURL() {
			// TODO Auto-generated method stub
			return this.request.isRequestedSessionIdFromURL();
		}
		public boolean isRequestedSessionIdFromUrl() {
			// TODO Auto-generated method stub
			return this.request.isRequestedSessionIdFromUrl();
		}
		public boolean isRequestedSessionIdValid() {
			// TODO Auto-generated method stub
			return this.request.isRequestedSessionIdValid();
		}
		public boolean isUserInRole(String role) {
			// TODO Auto-generated method stub
			return this.request.isUserInRole(role);
		}
		public Object getAttribute(String name) {
			// TODO Auto-generated method stub
			return this.getAttribute(name);
		}
		public Enumeration getAttributeNames() {
			// TODO Auto-generated method stub
			return this.request.getAttributeNames();
		}
		public String getCharacterEncoding() {
			// TODO Auto-generated method stub
			return this.request.getCharacterEncoding();
		}
		public int getContentLength() {
			// TODO Auto-generated method stub
			return this.request.getContentLength();
		}
		public String getContentType() {
			// TODO Auto-generated method stub
			return this.request.getContentType();
		}
		public ServletInputStream getInputStream() throws IOException {
			// TODO Auto-generated method stub
			return this.request.getInputStream();
		}
		public String getLocalAddr() {
			// TODO Auto-generated method stub
			return this.request.getLocalAddr();
		}
		public String getLocalName() {
			// TODO Auto-generated method stub
			return this.request.getLocalName();
		}
		public int getLocalPort() {
			// TODO Auto-generated method stub
			return this.request.getLocalPort();
		}
		public Locale getLocale() {
			// TODO Auto-generated method stub
			return this.request.getLocale();
		}
		public Enumeration getLocales() {
			// TODO Auto-generated method stub
			return this.request.getLocales();
		}
		
		public Map getParameterMap() {
			// TODO Auto-generated method stub
			return this.request.getParameterMap();
		}
		public Enumeration getParameterNames() {
			// TODO Auto-generated method stub
			return this.request.getParameterNames();
		}
		public String[] getParameterValues(String name) {
			// TODO Auto-generated method stub
			return this.request.getParameterValues(name);
		}
		public String getProtocol() {
			// TODO Auto-generated method stub
			return this.request.getProtocol();
		}
		public BufferedReader getReader() throws IOException {
			// TODO Auto-generated method stub
			return this.request.getReader();
		}
		public String getRealPath(String path) {
			// TODO Auto-generated method stub
			return this.request.getRealPath(path);
		}
		public String getRemoteAddr() {
			// TODO Auto-generated method stub
			return this.request.getRemoteAddr();
		}
		public String getRemoteHost() {
			// TODO Auto-generated method stub
			return this.getRemoteHost();
		}
		public int getRemotePort() {
			// TODO Auto-generated method stub
			return this.getRemotePort();
		}
		public RequestDispatcher getRequestDispatcher(String path) {
			// TODO Auto-generated method stub
			return this.request.getRequestDispatcher(path);
		}
		public String getScheme() {
			// TODO Auto-generated method stub
			return this.request.getScheme();
		}
		public String getServerName() {
			// TODO Auto-generated method stub
			return this.request.getServerName();
		}
		public int getServerPort() {
			// TODO Auto-generated method stub
			return this.request.getServerPort();
		}
		public boolean isSecure() {
			// TODO Auto-generated method stub
			return this.request.isSecure();
		}
		public void removeAttribute(String name) {
			// TODO Auto-generated method stub
			
		}
		public void setAttribute(String name, Object o) {
			// TODO Auto-generated method stub
			
		}
		public void setCharacterEncoding(String env)
				throws UnsupportedEncodingException {
			// TODO Auto-generated method stub
			
		}
		
	}*/
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
