package cn.lnu.demo;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ImageMail {

	/**
	 * @param args
	 * @throws MessagingException 
	 */
	public static void main(String[] args) throws Exception {
	//�����ʼ�
		Session session=Session.getDefaultInstance(new Properties());
		MimeMessage message=new MimeMessage(session);

		message.setFrom(new InternetAddress("ms15941699808@163.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("862998004@qq.com"));
		message.setSubject("test");
		
		//�����ʼ��е�����
		//1�����ʼ�����
		MimeBodyPart text=new MimeBodyPart();
		text.setContent("shfhafha;fha<br/><img src='cid:image1'><br/>fha;hfajh", "text/html");
		
		//2����ͼƬ����
		MimeBodyPart image=new MimeBodyPart();
		DataHandler dh=new DataHandler(new FileDataSource("src/1.jpg"));  //jaf���������ݴ����������Զ���֪�ļ����ͣ�����֪���ļ�����д��image��,���ԾͲ��������Լ��ֶ���������������
		image.setDataHandler(dh);
		image.setContentID("image1");
		
		//��������֮��Ĺ�ϵ
		MimeMultipart mm=new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(image);
		mm.setSubType("related");
		
		message.setContent(mm);
		message.saveChanges();
		
		message.writeTo(new FileOutputStream("c:\\1.eml"));
	}

}
