package cn.lnu.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//���Ʊ�ǩ�������Ƿ�����Ĵ�������
public class TagDemo1 extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		
		return Tag.EVAL_BODY_INCLUDE;//��ʾ��ʼ��ǩ����֮�����ǩ��
		//return Tag.SKIP_BODY;//��ʾ��ʼ��ǩ����֮���ڴ����ǩ��
	}
	
}
