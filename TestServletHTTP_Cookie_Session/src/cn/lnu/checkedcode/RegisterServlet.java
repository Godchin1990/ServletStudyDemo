package cn.lnu.checkedcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ע��servlet
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��������������⣬������֤��Ƚϲ�����ȷ
		request.setCharacterEncoding("UTF-8");
		
		//��ע��֮ǰУ���û��������֤���Ƿ���Ч
		//�õ��ͻ����������������֤��
		String c_checkedcode=request.getParameter("checkcode");
		//�õ�������session�б����ͼƬ��֤��
		String s_checkedcode=(String) request.getSession().getAttribute("checkcode");
		if(c_checkedcode!=null && s_checkedcode!=null && c_checkedcode.equals(s_checkedcode)){
			System.out.println("�����û�ע������!!");
		}else{
			//��֤���������
			System.out.println("������֤�����!");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
