package cn.lnu.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//������ύ����
public class DoFormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String username=request.getParameter("username");
		
		//����˯��3��ģ������������ӳ٣��������ظ�����ύ��ť��ʱ���ģ������ظ��ύ��������
		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�����ݿ���ע���û�---");*/
		
		boolean b=isTokenValid(request);
		if(!b){//���Ϊfalse����ʾ֮ǰ�Ѿ��ύ����
			System.out.println("�벻Ҫ�ظ��ύ��");
			return;
		}
		
		//Ϊtrue��ʾ��û���ύ�������ύ����ɾ������
		request.getSession().removeAttribute("token");
		System.out.println("�����ݿ���ע���û�~~~");
		
	}
	//�ж����Ʊ����Ƿ���Ч
	private boolean isTokenValid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//������Կͻ�����������token
		String Client_token=request.getParameter("token");
		if(Client_token==null){//�жϿͻ����Ƿ��token������һ�㶼���������������ô����Ϊ�˷�ֹhacker�����ύ
			return false;
		}
		//������Է������˴�������token
		String Server_token=(String) request.getSession().getAttribute("token");
		if(Server_token==null){//�û��Ѿ��ύ��һ�Ρ����������Ѿ�ɾ��token
			return false;
		}
		//����ͻ�����������token�ͷ������˵�token��һ�£�Ҳ��Ϊ���ظ��ύ
		if(!Client_token.equals(Server_token)){
			return false;
		}
		
		return true;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
