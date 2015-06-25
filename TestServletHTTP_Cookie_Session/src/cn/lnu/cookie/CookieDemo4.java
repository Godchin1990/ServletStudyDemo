package cn.lnu.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��ʾ��Ʒ��ϸ��Ϣ��servlet
public class CookieDemo4 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//1 �����û���������Ӵ�����id����ʾ��Ӧ��Ʒ����ϸ��Ϣ
		String id=request.getParameter("id");
		Book book=(Book)Db.getAll().get(id);
		out.write(book.getId()+"<br/>");
		out.write(book.getName()+"<br/>");
		out.write(book.getAuthor()+"<br/>");
		out.write(book.getDesription()+"<br/>");
		
		//2 ����cookie����д�������
		String cookieValue=buildCookie(id,request);
		Cookie cookie=new Cookie("bookHistory",cookieValue);
		cookie.setMaxAge(1*30*24*3600);
		cookie.setPath("/TestServletHTTP_Cookie_Session");
		response.addCookie(cookie);
	}

	//��ι���cookieֵ
	private String buildCookie(String id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//����cookie��ౣ������
		//��һ��ʱ���û�û�д��κ�cookie����ʱbookHistory=null  �򷵻�idֵ
		
		//�û���cookie��ʱ������bookHistory Ϊ2 ��5,1,  1 ����1,2,5
		
		//�û���cookie��ʱ������bookHistory Ϊ2 ��5,1,  ��������ǰֵ3 ����3,2,5
		
		//�û���cookie��ʱ������bookHistory Ϊ2 ��5    1	����1,2,5
		String bookHistory=null;
		Cookie cookies[]=request.getCookies();
		//����û���cookie��������bookHistory����Ϊ��cookieֵ
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory")){
				bookHistory=cookies[i].getValue();
			}
		}
		//��ʾ�û�û�д�cookie����
		if(bookHistory==null){
			return id;
		}
		
		LinkedList<String> list=new LinkedList(Arrays.asList(bookHistory.split("\\,")));
		
		if(list.contains(id)){//����������а���id ���û���cookie��ʱ������bookHistory Ϊ2 ��5,1,  1 ����1,2,5
			list.remove(id);
			list.addFirst(id);
		}else if(list.size()>=3){//���������id�������������ڵ���3 ���û���cookie��ʱ������bookHistory Ϊ2 ��5,1,  ��������ǰֵ3 ����3,2,5
			list.removeLast();
			list.addFirst(id);
		}else {//���������id����������С��3  ���û���cookie��ʱ������bookHistory Ϊ2 ��5    1	����1,2,5
			list.addFirst(id);
			
		}
		
		//���bookHistoryת��Ϊ1,2,3�ɶ��ŷָ����ַ�������
		StringBuffer sb=new StringBuffer();
		for(String bid : list){
			sb.append(bid+",");
		}
		bookHistory=sb.deleteCharAt(sb.length()-1).toString();
		return bookHistory;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
