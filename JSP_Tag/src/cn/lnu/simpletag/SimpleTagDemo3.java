package cn.lnu.simpletag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//��дʹ�ü򵥱�ǩ�ķ���ʵ���޸ı�ǩ�����ݵı�ǩ��������
public class SimpleTagDemo3 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		
		//���Ȼ�ñ�ǩ��
		JspFragment jf=this.getJspBody();
		//����ǩ�������޸�Ϊ��д��������Ҫ����ǩ����������д�����滺��
		StringWriter sw=new StringWriter();
		jf.invoke(sw);
		//�ӻ����л�ñ�ǩ�����ݣ������޸�
		String content=sw.toString();
		content=content.toUpperCase();
		//�ٽ��޸�֮�������д�������
		this.getJspContext().getOut().write(content);
	}
}
