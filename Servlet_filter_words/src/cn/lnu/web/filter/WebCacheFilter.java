package cn.lnu.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import cn.lnu.web.filter.GzipFilter.MyServletOutputStream;

public class WebCacheFilter implements Filter {
	private Map<String,byte[]> map=new HashMap();//��ס�������ݵ�map����
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		//1���õ��û���������ʵ���Դ��uri����������uri=/Servlet_filter_words/servlet/ServletDemo4
		String uri=request.getRequestURI();
		System.out.println("uri="+uri);
		//2,��map�������Ƿ񱣴��˸���Դ������
		byte b[]=map.get(uri);
		//3�����������(��ʾ���ǵ�һ�η��ʣ�ֱ���õ�����)����ֱ��ȡ�����ݴ�������
		if(b!=null){
			response.getOutputStream().write(b);
			return;
		}
		//4,���û�б�������(˵���ǵ�һ�η���)���������Ŀ����Դִ�У���ʱ����Ҫдһ��response�İ�װ�࣬����Ŀ����Դ�����
		MyResponse myresponse=new MyResponse(response);
		chain.doFilter(request, myresponse);
		byte data[]=myresponse.getBuffer();
		//5,����ԴuriΪ�ؼ��֣�����Դ�����ݱ��浽map�����У��Ա��´η���
		map.put(uri, data);
		//6��������ݸ������
		response.getOutputStream().write(data);
	}
	
	class MyResponse extends HttpServletResponseWrapper{
		private ByteArrayOutputStream bout=new ByteArrayOutputStream();//ά��һ�������������ֽ����鱣�浽�������
		private PrintWriter pw;
		private HttpServletResponse response;
		public MyResponse(HttpServletResponse response) {
			super(response);
			this.response=response;
		}
		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			
			
			return new MyServletOutputStream(bout);  //myresponse.getOutputStream.write("afhsaa");,�������ս�����bout��
		}
		@Override
		public PrintWriter getWriter() throws IOException {
			//pw=new PrintWriter(bout); //PrintWriter.Write("�й�")���ڲ���ȥ��gb2312���,�ĳ����淽ʽ,reponse���õ���ʲô��������Ϊʲô���
			pw=new PrintWriter(new OutputStreamWriter(bout,response.getCharacterEncoding()));
			return pw;//myresponse.getWriter().write("hdalhfahfa")��//���ַ������д��������̫С�����Ὣ����д���ײ㻺�����У�����ֱ��д��printWriter�Ļ����У�getBuffer()ʱ�ӵײ����о�ȡ��������
		}	
		
		//�Զ��庯�����õ�bout�������е�����
		public byte[] getBuffer(){
			if(pw!=null){
				pw.close();//ȷ��printwriter��ʽ����������̫С����д���ײ������ֶ�close֮������д���ײ���bout��ȥ
			}
			return bout.toByteArray();
		}
	}
	//����һ�����࣬����������
	class MyServletOutputStream extends ServletOutputStream{
		private ByteArrayOutputStream bout;
		public MyServletOutputStream(ByteArrayOutputStream bout){//����һ���������û�������д��������л�������
			this.bout=bout;
		}
		
		@Override
		public void write(int b) throws IOException {
			// TODO Auto-generated method stub
			bout.write(b);
		}
		
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}
}
