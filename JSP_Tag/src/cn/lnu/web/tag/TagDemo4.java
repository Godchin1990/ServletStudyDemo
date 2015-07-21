package cn.lnu.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
//��д�޻���ǩ���ദ������ʵ�ֽ���ǩ������ת��Ϊ��д
public class TagDemo4 extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return BodyTag.EVAL_BODY_BUFFERED;//���ִ��֮�󣬷�������ִ�е���ǩ��ʱ���Ὣ�俴��һ�����󱣴������������setBodyContent(),����ǩ�屣�浽һ��������
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		//�ڽ�����ǩʱ��ñ�ǩ�����ݣ�Ȼ�������޸�
		BodyContent bc=this.getBodyContent();
		String content=bc.getString();
		content=content.toUpperCase();
		try {
			this.pageContext.getOut().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return Tag.EVAL_PAGE;//����ֻ�ǶԱ�ǩ�����������޸ģ������jsp���ݻ�Ҫִ����ʾ������˴�����EVAL_PAGE
		//return super.doEndTag();
	}
	
	
}
