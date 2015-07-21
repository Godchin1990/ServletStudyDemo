package cn.lnu.web.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
//�������дʻ�Ĺ�����
public class wordsFilter implements Filter {
	private List<String> banWords = new ArrayList();//ȡ����ÿһ�������൱��һ��������ʽ
	private List<String> auditWords = new ArrayList();
	private List<String> replaceWords = new ArrayList();
	
	public void init(FilterConfig filterConfig) throws ServletException {
		try{
			String path = wordsFilter.class.getClassLoader().getResource("cn/lnu/words").getPath();
			File files[] =  new File(path).listFiles();
			for(File file : files){
				if(!file.getName().endsWith(".txt")){
					continue;
				}
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line=br.readLine())!=null){
					String s[] = line.split("\\|");
					if(s.length!=2){
						continue;
					}
					if(s[1].trim().equals("1")){
						banWords.add(s[0].trim());
					}
					
					if(s[1].trim().equals("2")){
						auditWords.add(s[0].trim());
					}
					
					if(s[1].trim().equals("3")){
						replaceWords.add(s[0].trim());
					}
				}
			}
			System.out.println("haha");
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//���������µ������е���������û�����дʻ�
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		//����ύ�������Ƿ��н��ô�
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String) e.nextElement();
			String data=request.getParameter(name);
			String regdata=data.replaceAll(" +", "");//����������еĴ��ڵ�һ�������ո��滻Ϊ"",��ȥ���ո�
			for(String regex:banWords){
				Pattern pattern=Pattern.compile(regex);//���ַ���ʽ��������ʽ����Ϊ�����ʽ��������ʽ
				Matcher match=pattern.matcher(regdata);//�����������ʽ����ȥƥ���ַ���data
				if(match.find()){//����ַ���data�д��ڿ��Ա�pattern�������ƥ����Ӵ���find�����ͷ���true�����򷵻�false
					request.setAttribute("message", "�����а����Ƿ��ʻ㣬��������ύ");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;
				}
			}
		}
		
		//�����˴ʣ�������˴ʣ�������������ԭ�е�request��û�и������ܣ���Ҫ��ǿ֮���ٷ���
		
		//����滻�ʣ�Ҳ�Ƿ��У�Ҳ��Ҫ��ǿrequest
		chain.doFilter(new MyRequest(request), response);
	}
	
	class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request){
			super(request);
			this.request=request;
		}
		@Override
		public String getParameter(String name) {//ʹ�÷���֮��servletDemo1�л�������Ǹ���֮�������
			// TODO Auto-generated method stub
			String data=request.getParameter("resume");//�����Ȼ��û�и���֮ǰ������
			//��������������û����˴ʣ��еĻ�����������
			if(data==null){
				return null;
			}
			
			for(String regex:auditWords){
				Pattern pattern=Pattern.compile(regex);//java���Pattern�������һ��������ʽ
				Matcher m=pattern.matcher(data);//����һ����ʾƥ������ƥ����
				if(m.find()){//��ʾ�����д�����˴ʻ㣬����˵�����ǡ�����һ�ѷ�����ǹ����Ҫ�缦�𣿡�,���������ǹ����˴�
					String value=m.group();//��ʾ�ҵ��ͻ����ύ��������ƥ��������ʽ�����ݣ����Ƿ�����ǹ ��
					//��ԭʼ�����滻�ɸ�������,Ȼ����data�ٽ�ÿ���滻���֮������ݼ�ס
					data=data.replaceAll(regex, "<font color='red'>"+value+"</font>");
				}		
			}	
			
			//����Ƿ����滻��
			for(String regex:replaceWords){
				Pattern pattern=Pattern.compile(regex);//java���Pattern�������һ��������ʽ
				Matcher m=pattern.matcher(data);//����һ����ʾƥ������ƥ����
				if(m.find()){//��ʾ�����д����滻
					//���������滻�ʵ�������****�滻��
					data=data.replaceAll(regex, "****");
				}		
			}	
			//����һ�ѷ�����ǹ����Ҫ�缦��****�𣿣���ǿ֮��Ľ���ǣ�������ǹ�͵缦����˴ʸ����ɺ�ɫ���Ĵ󽢶��滻�ʣ��滻��****
			return data;
		}	
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
