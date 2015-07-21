package cn.lnu.web.tag.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForeachTag2 extends SimpleTagSupport {
	private Object items;
	private String var;
	private Collection collection;//����items��ʲô���͵Ķ���ת��Ϊ���м��ϣ������doTag��ͳһ����
	public void setItems(Object items) {
		this.items = items;
		
		if(items instanceof Collection){
			collection=(Collection)items;//list set
		}
		if(items instanceof Map){
			Map map=(Map)items;
			collection=map.entrySet();//set
		}
		
		/*if(items instanceof Object[]){
			Object obj[]=(Object[]) items;
			collection=Arrays.asList(obj);//Arrays���asList�ķ�������һ���ɱ����������һ������������Է���һ��list���
		}*/
		
		if(items.getClass().isArray()==true){
			this.collection=new ArrayList();
			int length=Array.getLength(items);//Array�����������Զ��κ�һ��java�е�������д���,������ṩ�˲���java����Ľӿ�
			for(int i=0;i<length;i++){
				Object value=Array.get(items, i);
				this.collection.add(value);
			}
		}
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext=(PageContext) this.getJspContext();
		//��collection���е���
		Iterator it=this.collection.iterator();
		while(it.hasNext()){
			Object value=it.next();
			//pageContext.setAttribute(var, value);
			this.getJspContext().setAttribute(var, value);
			this.getJspBody().invoke(null);
		}
	}

	
}
