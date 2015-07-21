package cn.lnu.web.formbean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CotrolForm {
	private String tcount;
	private String scount;
	private String mcount;
	private String vcount;
	
	//����һ�����ϣ��û�����������Ϣ
	private Map errors=new HashMap();
	
	public String getTcount() {
		return tcount;
	}

	public void setTcount(String tcount) {
		this.tcount = tcount;
	}

	public String getScount() {
		return scount;
	}

	public void setScount(String scount) {
		this.scount = scount;
	}

	public String getMcount() {
		return mcount;
	}

	public void setMcount(String mcount) {
		this.mcount = mcount;
	}

	public String getVcount() {
		return vcount;
	}

	public void setVcount(String vcount) {
		this.vcount = vcount;
	}

	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}
	
	//�Զ���һ�������Ա��е����ݽ���У�飬У��ɹ�����true,ʧ�ܷ���false
	/*
	 * 	У�����
	 * ��ʦ����Ŀ����Ϊ�գ�����Ҫ��2-4֮�������
	 * ѧ������Ŀ����Ϊ�գ�������1-2֮�������
	 * ģ������Ŀ����Ϊ�գ�������1-2֮�������
	 * TV��Ŀ����Ϊ�գ����ұ�����1
	 * */
	public boolean validate(HttpServletRequest request) throws Exception{
		boolean isOK=true;
		//��֤��ʦ��Լ������
		if(this.tcount==null || this.tcount.trim().equals("")){
			isOK=false;
			errors.put("tcount", "��ʦ����Ŀ����Ϊ�գ�");
		}else {
			if(!this.tcount.matches("[234]")){
				isOK=false;
				errors.put("tcount", "��ʦ����Ŀ������2-4��Χ�����֣�");
			}
		}
		//��֤ѧ����Լ������
		if(this.scount==null || this.scount.trim().equals("")){
			isOK=false;
			errors.put("scount", "ѧ������Ŀ����Ϊ�գ�");
		}else {
			if(!this.scount.matches("[12]")){
				isOK=false;
				errors.put("scount", "ѧ������Ŀ������1-2��Χ�����֣�");
			}
		}
		
		//��֤ģ����Լ������
		if(this.mcount==null || this.mcount.trim().equals("")){
			isOK=false;
			errors.put("mcount", "ģ������Ŀ����Ϊ�գ�");
		}else {
			if(!this.mcount.matches("[12]")){
				isOK=false;
				errors.put("mcount", "ģ������Ŀ������1-2��Χ�����֣�");
			}
		}
		//��֤TVԼ������
		if(this.vcount==null || this.vcount.equals("")){
			isOK=false;
			errors.put("vcount", "TV��Ŀ����Ϊ�գ�");
		}else{
			if(!this.vcount.matches("[1]")){
				isOK=false;
				errors.put("vcount", "TV��Ŀ����Ϊ����1��");
			}
		}
		
		return isOK;
	}
}
