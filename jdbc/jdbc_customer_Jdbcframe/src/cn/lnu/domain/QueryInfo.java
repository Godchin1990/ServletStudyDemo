package cn.lnu.domain;
//��װ�ͻ��˴������Ĳ�ѯ����
public class QueryInfo {
	private int currentpage=1;//��ʾ�ͻ���ǰ����ҳ
	private int pagesize=5;//��ס�û��뿴��ҳ���С
	
	//�õ�������ֵ��������û�����ҳ������������ݿ��е���ʼλ��
	private int startindex;

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getStartindex() {
		this.startindex=(this.currentpage-1)*this.pagesize;
		return startindex;
	}
}
