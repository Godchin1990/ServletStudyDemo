package cn.lnu.web.tag.example;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport {
	private String site;
	private String page;
	
	public void setSite(String site) {
		this.site = site;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext=(PageContext) this.getJspContext();
		
		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response=(HttpServletResponse) pageContext.getResponse();
		//1���õ�������referer
		String referer=request.getHeader("referer");
		//2���ж������ߵ�ҳ���ǲ���Ҫ����������վ
		if(referer==null || !referer.startsWith(site)){//�ǵ�����
			if(page.startsWith(request.getContextPath())){
				response.sendRedirect(page);
			}else if(page.startsWith("/")){
				response.sendRedirect(request.getContextPath()+page);
			}else{
				response.sendRedirect(request.getContextPath()+"/"+page);
			}
			//����ǵ����ߣ�jsp���µ�ҳ��Ͳ��������߲鿴
			throw new SkipPageException();
		}
	}
}
