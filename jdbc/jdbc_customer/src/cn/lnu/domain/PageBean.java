package cn.lnu.domain;

import java.util.List;

//��װweb����Ҫ�ṩ���û�ҳ����ʾ������
public class PageBean {
	private List list;//��װ�û��뿴��ҳ������
	private int totalrecord;//��¼�ܼ�¼��
	private int pagesize;//��¼ҳ���С
	
	private int totalpage;//��¼��ҳ��
	private int currentpage;//��¼��ǰҳ
	private int previouspage;//��¼��һҳ
	private int nextpage;//��¼��һҳ
	private int[] pagebar;//��¼ҳ���� 1 2 3 4 5...
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {//�����ܼ�¼����ҳ���С�����ҳ��
		//100 5 20
		//101 5 21
		//99 5 20
		if(this.totalrecord%this.pagesize==0){
			this.totalpage=this.totalrecord/this.pagesize;
		}else{
			this.totalpage=this.totalrecord/this.pagesize+1;
		}
		
		return totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {//���ݵ�ǰҳ�����һҳ
		if(this.currentpage-1<1){
			this.previouspage=1;
		}else{
			this.previouspage=this.currentpage-1;
		}
		return previouspage;
	}
	
	public int getNextpage() {//���ݵ�ǰҳ�����һҳ
		if(this.currentpage+1>=this.totalpage){
			this.nextpage=this.totalpage;
		}else{
			this.nextpage=this.currentpage+1;
		}
		return nextpage;
	}

	public int[] getPagebar() {//������ҳ������ҳ����
		/*int pagebar[]=new int[this.totalpage];//ҳ������ʾ����ҳ
		for(int i=1;i<=pagebar.length;i++){
			pagebar[i-1]=i;
		}
		this.pagebar=pagebar;
		return pagebar;*/
		
		//���ڿ���ҳ����ÿ����ʾ10ҳ
		int pagebar[]=null;
		int startpage;//ҳ������ʾ����ʼҳ��
		int endpage;//ҳ������ʾ�Ľ���ҳ��
		if(this.totalpage<=10){//�����ǰҳ������С��10
			pagebar=new int[this.totalpage];
			startpage=1;
			endpage=this.totalpage;
		}else{//��ҳ������10�����ݵ�ǰҳ�����ҳ������ʼҳ�ͽ���ҳ
			pagebar=new int[10];
			startpage=this.currentpage-4;
			endpage=this.currentpage+5;
			//������������������ҳ��=30 ��ǰҳ=3 startpage=-1
			//��ҳ��=30 ��ǰҳ=29 endpage=34 ����ҳ������ 21 30
			if(startpage<1){
				startpage=1;
				endpage=10;
			}
			if(endpage>this.totalpage){
				endpage=this.totalpage;
				startpage=this.totalpage-9;
			}
		}
		//����ҳ������ʼ�ͽ���ҳ�����ҳ����
		int index=0;
		for(int i=startpage;i<=endpage;i++){
			pagebar[index++]=i;
		}
		
		this.pagebar=pagebar;
		return this.pagebar;
	}
}
