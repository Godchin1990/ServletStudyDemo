package cn.lnu.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//��дʹ�ü򵥱�ǩ�ķ���ʵ�ֱ�ǩ������ִ��5�εı�ǩ��������
public class SimpleTagDemo2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		
		//���Ȼ�ñ�ǩ��
		JspFragment jf=this.getJspBody();
		//����ǩ������ִ��5��
		for(int i=1;i<=5;i++){
			jf.invoke(null);//����nullҲ��Ĭ��д��������ȼ��� jf.invoke(this.getJspContext().getOut());
		}
	}
	
}
