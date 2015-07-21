package cn.lnu.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�г���վ���й������ļ�������������
public class ListFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������ҵ��������ļ�����Ŀ¼
		String path=this.getServletContext().getRealPath("/WEB-INF/upload");
		//ʹ�õݹ��г�Ŀ¼�������ļ�
		Map map=new HashMap();//ʹ��һ��map���ϱ������и�Ŀ¼�µ�һ���ļ�������ǰ̨jspҳ����ʾ
		listfile(new File(path),map);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/listfiles.jsp").forward(request, response);
	}
	//�������ݹ�����������ļ���ֻ�ǵݹ�������ļ������ᱣ���ļ�����Ŀ¼
	public void listfile(File file,Map map){
		if(!file.isFile()){//�����ж��������Ŀ¼�µ�����ļ��ǲ����ļ������ǵĻ���˵����һ��Ŀ¼
			File children[]=file.listFiles();//�õ����Ŀ¼�µ������ļ�
			for(File f:children){//�������Ŀ¼�µ��������ļ����ݹ����listfile�������г�������Ŀ¼�Լ���Ŀ¼�µ������ļ�
				listfile(f,map);
			}
		}else{//˵������ͨ�ļ�������Ŀ¼
			String filename=file.getName().substring(file.getName().indexOf("_")+1);//���ݷ������ṩ��uuid�����и���ļ�ԭʼ�ļ���  28134-4194-4121-644_a_b.txt-->a_b.txt
			map.put(file.getName(),filename ); //jspҳ��  <a href="/servlet/DownloadFileServlet?filename=�ļ��ڷ������е�ת��Ϊuuid������">�ļ���ԭʼ�ļ���</a>
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
