package cn.lnu.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//����
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		//ͨ��iͼ��Id��ö�Ӧͼ��
		Book book=(Book)Db.getAll().get(id);
		//���û���������Ϣ���ӵ�session�����û�����ʱ�����session�Ϳ��Ի���Ȿ��
		HttpSession session=request.getSession(false);
		//�ֹ���cookie��ʽ��sessionid���Խ���ر������֮���ϴι���Ķ�������
		//.....
		//Ϊ�˽������Ķ౾�飬��Ҫ���û����������֯��������Ȼ���ټӵ�session�У������û��ڽ���ʱ��ֻ���session�л�ü��Ͼ��ܵõ��û������ͼ����Ϣ
		//��session�еõ��û����ڱ���������ļ���(���ﳵ)
		List list=(List)session.getAttribute("list");
		if(list==null){
			list=new ArrayList();
			session.setAttribute("list", list);//��������ϼӵ�session��
		}
		list.add(book);
		
		//��ת�����ﳵҳ��,ע��˴����ܲ���ת���ķ�ʽ��תҳ�棬���ʹ��ת���ķ�ʽ��ת�����ﳵҳ�棬��ô�û��ڹ��ﳵҳ��ֻҪһˢ�£�
		//�ͻ��ٴν��ϴ����������һ�飬�⵱Ȼ���������뿴���ģ�����Ҫ�����ض���ķ�ʽ��תҳ��
		//request.getRequestDispatcher("/servlet/ListCarServlet").forward(request, response);
		//����url����д�����������û���ֹcookieʱ��ҳ����תʱ�����sessionid
		String context=request.getContextPath();///TestServletHTTP_Cookie_Session�õ�webӦ��Ŀ¼
		String url=response.encodeRedirectURL("/servlet/ListCarServlet");
		response.sendRedirect(context+url);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
