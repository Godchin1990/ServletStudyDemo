package cn.lnu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//ͨ��servletContext��ȡ��Դ�ļ�
public class ServletDemo8 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���������ļ��ڲ�ͬλ����λ�ȡ�����ļ���
		//test1();
		//test2();
		//test3();
		test4();
	}

	//��������ǲ���db.properties��srcĿ¼��ʱ��λ���ļ���
	public void test1() throws IOException {
		//�����Դ�ļ���,
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		//��ȡProperties�����ļ���ģ�巽ʽ��java����һ��Properties����
		Properties pros=new Properties();//�ڲ���map���Ϸ�ʽ����
		pros.load(in);//������ǽ��������е��������ϵ�pros������ȥ��
		
		String user=pros.getProperty("username");
		String passwd=pros.getProperty("password");
		String url=pros.getProperty("url");
		System.out.print(user+"  "+passwd+"  "+url);
	}
	//��������ǲ���db.properties��srcĿ¼��cn.lnu����ʱ��λ���ļ���
	public void test2() throws IOException {
		//�����Դ�ļ���
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/cn/lnu/db.properties");
		//��ȡProperties�����ļ���ģ�巽ʽ��java����һ��Properties����
		Properties pros=new Properties();//�ڲ���map���Ϸ�ʽ����
		pros.load(in);//������ǽ��������е��������ϵ�pros������ȥ��
		
		String user=pros.getProperty("username");
		String passwd=pros.getProperty("password");
		String url=pros.getProperty("url");
		System.out.print(user+"  "+passwd+"  "+url);
	}
	
	//��������ǲ���db.properties��WebRoot��ʱ��λ���ļ���
	public void test3() throws IOException {
		//�����Դ�ļ���
		InputStream in=this.getServletContext().getResourceAsStream("/db.properties");
		//��ȡProperties�����ļ���ģ�巽ʽ��java����һ��Properties����
		Properties pros=new Properties();//�ڲ���map���Ϸ�ʽ����
		pros.load(in);//������ǽ��������е��������ϵ�pros������ȥ��
		
		String user=pros.getProperty("username");
		String passwd=pros.getProperty("password");
		String url=pros.getProperty("url");
		System.out.print(user+"  "+passwd+"  "+url);
	}
	
	//��������ǲ���db.properties��src��ʱ���ͨ��servletContext��getRealPath������������ļ��ľ���·����ͨ����ͳ��ȥ����ļ����ķ�ʽ
	public void test4() throws IOException {
		//���������ļ��ľ���·��
		String path=this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		String filename=path.substring(path.lastIndexOf("\\")+1);//�����Դ����
		System.out.println("��ǰ�����ļ����ǣ� "+filename);
		//�����Դ�ļ���
		FileInputStream in=new FileInputStream(path);
		
		//��ȡProperties�����ļ���ģ�巽ʽ��java����һ��Properties����
		Properties pros=new Properties();//�ڲ���map���Ϸ�ʽ����
		pros.load(in);//������ǽ��������е��������ϵ�pros������ȥ��
		System.out.println("��ǰ�����ļ�������Ϣ�ǣ� ");
		String user=pros.getProperty("username");
		String passwd=pros.getProperty("password");
		String url=pros.getProperty("url");
		System.out.print(user+"  "+passwd+"  "+url);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
