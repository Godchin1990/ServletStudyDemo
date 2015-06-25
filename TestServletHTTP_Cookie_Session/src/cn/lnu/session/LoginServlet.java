package cn.lnu.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ʹ��session�����½����״̬
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//�õ������ύ�������û���������֮�����ȼ�����ݿ���û�ж�Ӧ���û�
		List<User> list=Db.getAll();
		
		for(User user:list){
			if(user.getUsername().equals(username)&& user.getPasswd().equals(password)){
				request.getSession().setAttribute("user", user);//��½�ɹ�����session�д���һ����½�ɹ����
				response.sendRedirect("/TestServletHTTP_Cookie_Session/index.jsp");
				return;
			}
		}
		
		//������ݿ��в����ڶ�Ӧ�û���������ĵ�½���������������û����������벻��ȷ����
		//���������������
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.print("��������û����������벻��ȷ��<br/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
	}

}

class Db{
	public static List list=new ArrayList();
	static {
		list.add(new User("aaa","123"));
		list.add(new User("bbb","234"));
		list.add(new User("ccc","2543"));
	}
	
	public static List getAll(){
		return list;
	}
}
class User{
	private String username;
	private String passwd;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String passwd) {
		super();
		this.username = username;
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}