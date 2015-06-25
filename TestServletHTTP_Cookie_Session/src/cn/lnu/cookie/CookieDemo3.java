package cn.lnu.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//������ҳ��Servlet��Demo3��Demo4һ���ʾ������ʾ���������Ʒ����
public class CookieDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���������������
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//1 �����վ������Ʒ
		out.write("����վ��������Ʒ��<br/>");
		Map<String,Book> map=Db.getAll();
		for(Map.Entry<String, Book> entry:map.entrySet()){
			Book book=entry.getValue();
			//�õ�һ������֮��������������д������
			out.print("<a href='/TestServletHTTP_Cookie_Session/servlet/CookieDemo4?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br/>");
			
			
		}
		//2 ��ʾ�û��������������Ʒ
		out.print("<br/>�����������������Ʒ��<br/>");
		Cookie cookies[]=request.getCookies();
		
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory")){
				String ids[]=cookies[i].getValue().split("\\,");
				for(String id:ids){
					Book book=(Book)Db.getAll().get(id);
					//out.print(book.getName()+"<br/>");
					out.print("<a href='/TestServletHTTP_Cookie_Session/servlet/CookieDemo4?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br/>");
				}
			}
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
//ʹ��Db��ģ�����ݿ�
class Db{
	//ʹ��LinkedHashMap��Ϊ�˱�֤���������˳�򲻷����仯
	private static Map<String,Book> map=new LinkedHashMap();
	static{
		map.put("1", new Book("1","javaWeb����","mushroom","javaWebb�ر�����"));
		map.put("2", new Book("2","jdbc����","mushroom","javaWebb�ر�����"));
		map.put("3", new Book("3","spring3����","mushroom","javaWebb�ر�����"));
		map.put("4", new Book("4","structs2����","mushroom","javaWebb�ر�����"));
		map.put("5", new Book("5","herbnate����","mushroom","javaWebb�ر�����"));
	}
	
	public  static Map getAll(){
		return map;
	}
}

class Book{
	private String id;
	private String name;
	private String author;
	private String desription;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String id, String name, String author, String desription) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.desription = desription;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
	}
}