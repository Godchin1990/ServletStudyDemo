package cn.lnu.domain;

import java.util.List;

//��װ�����ݿ��в�ѯ�������
public class QueryResult {
	private List list;//��ס�û�����ҳ������
	private int totalrecord;//��ס�ܼ�¼��
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
	
}
