package cn.lnu;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lnu.dao.UserDao;
/*
 servlet��������������������������ζ�ȡ��Դ�ļ�(ͨ����װ����)
 */
public class ServletDemo9 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao=new UserDao();
		dao.update();
		//dao.find();//������λ�ȡ�������ϸ���֮��������ļ���Ϣ
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
