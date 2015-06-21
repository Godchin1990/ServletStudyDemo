package cn.lnu.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
//�������ͷ��Ϣ����������
public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(request);
		test2(request);
		
	}
	//��ȡ����������صķ���
	private void test2(HttpServletRequest request) throws IOException {
		System.out.println("------��ȡ���ݷ�ʽ1-------");
		//һ������������֮��Ҫ�ȼ���ʹ��
		String nameValue=request.getParameter("username");
		if(nameValue!=null && !nameValue.trim().equals("")){
			System.out.println(nameValue);
		}
		String nameValue2=request.getParameter("password");
		System.out.println(nameValue2);
		
		System.out.println("------��ȡ���ݷ�ʽ2-------");
		
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
			System.out.println(name+" = "+value);
		}
		
		System.out.println("------��ȡ���ݷ�ʽ3-------");
		
		String values[]=request.getParameterValues("username");
		for(int i=0;values!=null && i<values.length;i++){
			System.out.println(values[i]);
		}

		System.out.println("------��ȡ���ݷ�ʽ4-------");
		Map<String,String[]> map=request.getParameterMap();
		
		UserData userData=new UserData();
		try {
			BeanUtils.populate(userData,map);//��map�����е��������bean
			//BeanUtils.copyProperties(userData, fromBean); bean�Ŀ���
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(userData);
		
		System.out.println("------��ȡ���ݷ�ʽ5���ʺ����ļ��ϴ���һ���ȡ���ݲ������ַ�����-------");
		
		InputStream in=request.getInputStream();
		int len=0;
		byte buffer[]=new byte[1024];
		while((len=in.read(buffer))>0){
			System.out.println(new String(buffer,0,len));
		}
	}
	
	//��ȡrequest����ͷ��صķ���
	private void test1(HttpServletRequest request) {
		String headValue=request.getHeader ("Accept-Encoding");
		System.out.println(headValue);
		
		System.out.println("-------------");
		Enumeration e=request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			System.out.println((String)e.nextElement());
		}
		
		System.out.println("-------------");
		//��ӡ��������ͷ��
		e=request.getHeaderNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String value=request.getHeader(name);
			System.out.println(name+" = "+value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
