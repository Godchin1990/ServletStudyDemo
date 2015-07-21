package cn.lnu.web.tag.example;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//���ʸ��ױ�ǩ������
		ChooseTag parent=(ChooseTag) this.getParent();
		
		if(test && !parent.isDo()){//���test����true�����ҵܱܵ�ǩû�б�ִ��
			JspFragment jf=this.getJspBody();
			jf.invoke(null);
			
			parent.setDo(true);
		}
	}
	
}
