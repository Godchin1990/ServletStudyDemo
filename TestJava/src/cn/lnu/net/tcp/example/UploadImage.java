package cn.lnu.net.tcp.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//����ÿ��socket�ͻ���������߳�����
public class UploadImage implements Runnable {
	private Socket s;
	public UploadImage(Socket s){
		this.s=s;
	}
	public void run() {
		// TODO Auto-generated method stub
		String client_ip=s.getInetAddress().getHostAddress();
		System.out.println(client_ip+".....connected");
		File file = getFile("e:\\server_image",client_ip);
		InputStream in;
		try {
			in = s.getInputStream();
			FileOutputStream fos=new FileOutputStream(file);	
			byte[] buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))!=-1){
				fos.write(buf, 0, len);
			}
			//���ͻ��˻�������
			OutputStream out=s.getOutputStream();
			out.write("�ϴ�ͼƬ�ɹ�".getBytes());	
			//�ر���Դ
			fos.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static File getFile(String dir,String client_ip) {
		File image_dir=new File(dir);//�����������˱����ļ����ļ���
		if(!image_dir.exists()){
			image_dir.mkdir();
		}
		int count=1;
		File file=new File(image_dir,client_ip+"("+count+").jpg");
		while(file.exists()){
			count++;
			file=new File(image_dir,client_ip+"("+count+").jpg");
		}
		return file;
	}
}
