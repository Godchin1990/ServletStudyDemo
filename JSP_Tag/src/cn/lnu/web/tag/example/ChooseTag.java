package cn.lnu.web.tag.example;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	private boolean isDo;

	public boolean isDo() {//get
		return isDo;
	}

	public void setDo(boolean isDo) {//set
		this.isDo = isDo;
	}
//�Լ��Ǹ���ǩ,���븲��doTag,���Ʊ�ǩ��ִ��
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		this.getJspBody().invoke(null);
	}
	
}
