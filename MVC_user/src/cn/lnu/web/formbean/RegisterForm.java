package cn.lnu.web.formbean;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

//�����û��ύ�ı�
public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private String checkcode;
	//����һ�����ϣ��û�����������Ϣ
	private Map errors=new HashMap();
	
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	//�Զ���һ�������Ա��е����ݽ���У�飬У��ɹ�����true,ʧ�ܷ���false
	/*
	 * 	У�����
	 * �û�������Ϊ�գ�����Ҫ��3-8λ��ĸ
	 * ���벻��Ϊ�գ�������6-8λ����
	 * ȷ�����벻��Ϊ�գ�����Ҫ�����汣��һ��
	 * �������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
	 * ���տ���Ϊ�գ���Ϊ��ʱ��������һ������
	 * �ǳƲ�����Ϊ�գ�����Ҫ�Ǻ���
	 * */
	public boolean validate(HttpServletRequest request) throws Exception{
		boolean isOK=true;
		//�û�������Ϊ�գ����ұ�����3-8λ����ĸ���
		if(this.username==null||this.username.trim().equals("")){
			isOK=false;
			errors.put("username", "�û�������Ϊ�գ�");
		}else{
			if(!this.username.matches("[a-zA-Z]{3,8}")){
				isOK=false;
				errors.put("username", "�û�������Ϊ3-8Ϊ����ĸ!");
			}
		}
		//�������벻��Ϊ�գ�����ֻ����6-8λ������
		if(this.password==null||this.password.trim().equals("")){
			isOK=false;
			errors.put("password", "���벻��Ϊ�գ�");
		}else{
			if(!this.password.matches("\\d{6,8}")){
				isOK=false;
				errors.put("password", "�������Ϊ6-8Ϊ������!");
			}
		}
		//�����������һ��
		if(this.password2==null||this.password2.trim().equals("")){
			isOK=false;
			errors.put("password2", "ȷ�����벻��Ϊ�գ�");
		}else{
			if(!this.password.equals(this.password2)){
				isOK=false;
				errors.put("password2", "���������������һ�£�");
			}
		}
		//���䲻��Ϊ�գ����ұ�����һ���Ϸ�������
		if(this.email==null||this.email.trim().equals("")){
			isOK=false;
			errors.put("email", "���䲻��Ϊ�գ�");
		}else{
			//����������ʽ
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK=false;
				errors.put("email", "������һ���Ϸ������䣡");
			}
		}
		///���տ���Ϊ�գ���Ϊ��ʱ��������һ�����ڸ�ʽ
		if(this.birthday!=null && !this.birthday.trim().equals("")){
			//���ڵ�У�飬����beanutils��һ����DateLocaleConverter(��������ת����)
			try{
				DateLocaleConverter dl=new DateLocaleConverter();
				dl.convert(this.birthday, "yyyy-MM-dd");
			}catch(Exception e){
				isOK=false;
				errors.put("birthday", "�������ڸ�ʽ����ȷ��");
				}
		}
		//�ǳƲ���Ϊ�գ����ұ����Ǻ��֣���������Ϊ \u4e00-\u9fa5
		if(this.nickname==null||this.nickname.trim().equals("")){
			isOK=false;
			errors.put("nickname", "�ǳƲ���Ϊ�գ�");
		}else{
			if(!this.nickname.matches("^([\u4e00-\u9fa5]+)$")){
				isOK=false;
				errors.put("nickname", "�ǳƱ����Ǻ��֣�");
			}
		}
		
		String c_checkedcode=this.checkcode;
		//�õ�������session�б����ͼƬ��֤��
		String s_checkedcode=(String) request.getSession().getAttribute("checkcode");
		if(c_checkedcode==null || s_checkedcode==null || !c_checkedcode.equals(s_checkedcode)){
			isOK=false;
			errors.put("checkcode", "��֤�벻��ȷ��");
		}
		return isOK;
	}
	
	
}
