package cn.lnu.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//��дʹ�ü򵥱�ǩ�ķ���ʵ���Ƿ�ִ�б�ǩ�幦�ܵı�ǩ��������
public class SimpleTagDemo1 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		
		//���Ȼ�ñ�ǩ��
		JspFragment jf=this.getJspBody();
		//����ǩ��д�������,���ǲ�д������������ǩ������ݲ���ִ�У���������ʾ
		//jf.invoke(this.getJspContext().getOut());
	}
	
}
