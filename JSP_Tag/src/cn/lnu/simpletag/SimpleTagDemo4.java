package cn.lnu.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//��дʹ�ü򵥱�ǩ�ķ���ʵ�ֿ��Ʊ�ǩ���µ�jsp���ݲ�ִ�еı�ǩ��������
public class SimpleTagDemo4 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		
		throw new SkipPageException();
	}
}
