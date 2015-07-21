package cn.lnu.domain;

import java.util.Date;

/*
 * 			id varchar(40) primary key,
			uuidname varchar(100) not null unique,
			realname varchar(100) not null,
			savepath varchar(255) not null,
			uptime datetime not null,
			description varchar(255),
			username varchar(40) not null
 * */
public class Upfile {
	private String id;
	private String uuidname;//�ϴ��ļ������ƣ��ļ���uuid��
	private String realname;//�ϴ��ļ�����ʵ����
	private String savepath;//��ס�ϴ��ļ���λ��
	private Date uptime;//�ļ����ϴ�ʱ��
	private String description;//�ļ�������
	private String username;//�ϴ���
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
