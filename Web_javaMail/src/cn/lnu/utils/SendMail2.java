package cn.lnu.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.lnu.domain.User;

public class SendMail2 implements Runnable {//ͨ��ʵ��runnable�ӿڣ�ʵ��run�����������߳�������û����ʼ�����

	private  String host = "localhost";
	private  String email = "aaa@flx.com";
	private  String username = "aaa";
	private  String password = "123";
	
	private User user;
	
	public SendMail2(User user) {
		super();
		this.user = user;
	}

	public void run() {
		try{
			Thread.sleep(1000*30);
			send(user);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public  void send(User user) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.host", host);
		prop.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(prop);
		Message message = createmessage(session, user);
		Transport ts = session.getTransport();
		ts.connect(username, password);
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
	
	public  Message createmessage(Session session,User user) throws AddressException, MessagingException{
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
		message.setSubject("xxx��վ�û�ע���ʼ�");
		
		String content = "��ϲ����ע��ɹ�����ע����û�����"+ user.getUsername() +",��ע��������ǣ�" + user.getPassword() + ",��úñ��ܣ�������˭����";
		message.setContent(content, "text/html;charset=UTF-8");
		message.saveChanges();
		
		return message;
	}
}
