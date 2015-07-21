package cn.lnu.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
//ʵ��ȫվѹ���Ĺ�����,�����Ҫ��response������ǿ֮���ٷ���
public class GzipFilter implements Filter {

	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		MyResponse myresponse=new MyResponse(response);
		
		chain.doFilter(request, myresponse);//response.getWriter��response.getOutputStream������������Ҫ��ǿ�����ƽ����ݶ�д��myresponse�е�һ���������У�����һ���Լ�����
		//Ȼ��ȡ���������е����ݽ���ѹ������������
		byte out[]=myresponse.getBuffer();
		System.out.println("ѹ��֮ǰ��"+out.length);
		byte gzipout[]=gzip(out);
		System.out.println("ѹ��֮��"+gzipout.length);
		response.setHeader("content-encoding", "gzip");
		response.setHeader("content-length", gzipout.length+"");
		response.getOutputStream().write(gzipout);
	}

	public byte[] gzip(byte b[]) throws IOException{//����һ��byte���飬����һ��gzipѹ��֮���byte����
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		GZIPOutputStream gout=new GZIPOutputStream(bout);
		gout.write(b);//������д��bout��ȥ
		gout.close();
		
		return bout.toByteArray();
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
