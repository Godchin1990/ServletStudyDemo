package cn.lnu.demo;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class ComplexMail {

	/**
	 * ��������ӵ��ʼ�
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//�����ʼ�
		Session session = Session.getDefaultInstance(new Properties());
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("aaa@flx.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("bbb@flx.com"));
		message.setSubject("����");
		
		//����bodypart��װ����
		MimeBodyPart text=new MimeBodyPart();
		text.setContent("���������ļ�<br/><img src='cid:image1'><br/>fha;hfajh", "text/html;charset=UTF-8");
		//����bodypart��װͼƬ
		MimeBodyPart image=new MimeBodyPart();
		DataHandler dh=new DataHandler(new FileDataSource("src/1.jpg"));  //jaf���������ݴ����������Զ���֪�ļ����ͣ�����֪���ļ�����д��image��,���ԾͲ��������Լ��ֶ���������������
		image.setDataHandler(dh);
		image.setContentID("image1");
		//����bodypart��װ����
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler dh2 = new DataHandler(new FileDataSource("src/�������.mp3"));
		attach.setDataHandler(dh2);
		attach.setFileName(MimeUtility.encodeText(dh2.getName()));   //���ø�����,�ļ�����Ǹ����������������������������setFileName�����ڲ�������content-dispositionͷ
		
		//�������ݹ�ϵ
		MimeMultipart content=new MimeMultipart();
		content.addBodyPart(text);
		content.addBodyPart(image);
		content.setSubType("related");
		MimeBodyPart mbp=new MimeBodyPart();
		mbp.setContent(content);
		
		MimeMultipart mm=new MimeMultipart();
		mm.addBodyPart(mbp);
		mm.addBodyPart(attach);
		mm.setSubType("mixed");
		
		message.setContent(mm);
		message.saveChanges();
		message.writeTo(new FileOutputStream("c:\\1.eml"));
		
		
	}

}
