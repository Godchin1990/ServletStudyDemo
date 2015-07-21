package cn.lnu.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.lnu.domain.User;

//ֻҪ�û���¼�ˣ�����session�����һ��user���ԣ������������attributeAdded�����ͻ�ִ��
public class UserListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		//Map map=new HashMap();//���ַ������ã���Ϊÿ�ε�½һ���û������һ�����Ծ�Ҫnewһ��Map����
		Map map=(Map) se.getSession().getServletContext().getAttribute("map");//�õ�servletContext�е���ӵ�map����
		if(map==null){//ʹ�����ַ�����ֻ���ڵ�һ���û���¼,��session��������Ե�ʱ��Żᴴ��map����
			map=new HashMap();
			se.getSession().getServletContext().setAttribute("map", map);//ֻҪ���û���¼��������ӵ�servletContext���е�map������
		}
		Object obj=se.getValue();
		if(obj instanceof User){//�ж�session��ȡ����ֵ�ǲ���user��������ǣ���ʾ�û���¼��
			User user=(User)obj;
			map.put(user.getUsername(),se.getSession());//�ŵ�һ��map�����У����ڹ������˲�������½���û�
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

}
