package cn.lnu.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//��������ҳ�������Ƿ�����Ĵ�������
public class TagDemo2 extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		
		//return Tag.EVAL_PAGE;//��ʾ������ǩ֮�������������ҳ������
		return Tag.SKIP_PAGE;//��ʾ������ǩ֮���ټ�����������ҳ������
	}

}
