package cn.lnu.simpletag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//��д��������Եı�ǩ��������,ʵ������������count�α�ǩ������
public class SimpleTagDemo5 extends SimpleTagSupport {
	private int count;
	private Date date;//����������֧�ְ��ֻ����������͵�ת�������Դ��ݵ��ַ��������Զ�תΪ���ֻ������ͣ��������ڸ�ʽ�����ڰ��ֻ������ͣ�ֻ��ͨ��el���ʽ���߽ű����ʽ����Ȼ��Ҳ�����ڴ��������ж���ת����ʵ���ַ���ת���ڸ�ʽ����
	public void setCount(int count) {
		this.count = count;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		
		JspFragment jf=this.getJspBody();
		this.getJspContext().getOut().write(date.toLocaleString());
		for(int i=0;i<count;i++){
			jf.invoke(null);
		}
	}
	
	
}
