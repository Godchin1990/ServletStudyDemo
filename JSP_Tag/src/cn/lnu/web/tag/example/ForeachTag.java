package cn.lnu.web.tag.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForeachTag extends SimpleTagSupport {
	private Object items;
	private String var;//�൱�ڹؼ�������
	
	public void setItems(Object items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		List list=(List)items;
		Iterator it=list.iterator();
		while(it.hasNext()){
			Object value=it.next();
			this.getJspContext().setAttribute(var, value);//ÿ�ε�����һ�����ݾʹ���servletContext���var������
			this.getJspBody().invoke(null);//֪ͨ���������el���ʽ�Ӹ����var������ȡ����ǩ�����ݣ����ص����������ϴ�var�е�ֵ
		}
	}
	
	
}
