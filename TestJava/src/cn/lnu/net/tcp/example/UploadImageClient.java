package cn.lnu.net.tcp.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadImageClient {

	/**
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("�ϴ�ͼƬ�ͻ�������...");
		//1������Socket�ͻ���
		Socket s=new Socket("127.0.0.1",10006);
		//2,ȷ��Դ
		File file=new File("Lighthouse.jpg");
		FileInputStream fis=new FileInputStream(file);
		
		//ȷ��Ŀ�ģ�Socket�������
		OutputStream out=s.getOutputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=fis.read(buf))!=-1){
			out.write(buf, 0, len);
		}
		//���߷�����д����
		s.shutdownOutput();
		//��ȡ������������
		InputStream in=s.getInputStream();
		byte[] bufIn=new byte[1024];
		int lenIn=0;
		lenIn=in.read(buf);
		String data=new String(bufIn,0,lenIn);
		System.out.println(data);
		
		//�ر���Դ
		fis.close();
		s.close();
	}

}
