package cn.lnu.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
//����������ʹ�ö�̬���������������������������ݽ���ȫվѹ������Ҫ����ǿresponse�����getOutputStream��getWriter����
public class GzipFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		final HttpServletResponse response=(HttpServletResponse) resp;
		
		//ʹ�ö�̬���������ض�response���󷽷�����ǿresponse��getOutputStream��getWriter�����������Լ��������û�ͨ������������д������д������������Ȼ��ӻ�����ȡ�����ݽ���ѹ�������ظ���������Ӷ�ʵ��ȫվѹ����ͨ��chain���е���response�Ĵ���
		ResponseProxy proxy=new ResponseProxy(response);//�ȴ���һ��response���������������������
		chain.doFilter(request, proxy.createProxy());//ʹ��responseProxy.get...��������ʹ�ô�����response�����get����
		
		byte[] out=proxy.getBuffer();//����֮��Ŀ����Դ���ݶ����˻��������ӻ�������ȡ�����ݣ�����ѹ��
		
		//Ȼ��ȡ���������е����ݽ���ѹ������������
		System.out.println(new String(out,"UTF-8"));
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
	
	class ResponseProxy{
		private ByteArrayOutputStream bout=new ByteArrayOutputStream();//�������������ά��һ�����壬���û���sevlet�е�getOutputStream����getWriter����ʱ���Ƚ�����д��bout������
		private PrintWriter pw=null;
		public byte[] getBuffer(){
			if(pw!=null){
				pw.close();//ȷ��������������̫С������û�н��뻺��bout�У�����pw��
			}
			return bout.toByteArray();
		}
		
		
		private HttpServletResponse response;//���ڼ�ס����˭�Ĵ���
		public ResponseProxy(HttpServletResponse response){//ͨ�����캯������Ҫ��������Ķ���
			this.response=response;
		}
		public HttpServletResponse createProxy(){
			return (HttpServletResponse) Proxy.newProxyInstance(GzipFilter.class.getClassLoader(), response.getClass().getInterfaces(), new InvocationHandler(){

				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					
					if(!method.getName().equals("getOutputStream") && !method.getName().equals("getWriter")){//�������servlet���õĲ����������������Ͳ���response������ǿ������ԭ����response����������
						return method.invoke(response, args);
					}
					
					if(method.getName().equals("getOutputStream")){//servlet����getOutputStream��Ҫ����һ��ServletOutputStream����������Ҫ��ǿ�������Լ���outputStream����������д��������ȥ
						return new ServletOutputStream(){
							@Override
							public void write(int b) throws IOException {
								bout.write(b);//��������д���ײ�bout��������ȥ	
							}	
						};
					}
					
					if(method.getName().equals("getWriter")){//����serlet����getWriter��Ҫ����һ��PrintWriter����������Ҫ��ǿ�������Լ���Writer����������д��������ȥ
						pw=new PrintWriter(new OutputStreamWriter(bout,"UTF-8"));//����������ض���ʵresponse����ķ��ʣ��鿴�Ƿ���õ����������������ǣ�����һ���Լ���һ������������ǿ�������д���ײ㻺����bout�е���,Ϊ�˷�ֹ�����������⣬��Ҫʹ��һ��ת����OutputStreamWriter��ָ������UTF-8���
						return pw;//���ؽ�����д�������е���������servlet�п��Դӻ�����ȡ������ѹ��֮����д����������Ӷ�ʵ��ȫվѹ��
					}
					
					return null;
				}
				
			});
		}
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
