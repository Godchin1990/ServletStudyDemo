package cn.lnu.net.tcp.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadImageServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�ϴ�ͼƬ������������...");
		//����˶���
		ServerSocket ss=new ServerSocket(10006);
		while(true){
			Socket s=ss.accept();//ÿ��accept����һ���ͻ�������Ȼ�����洴��һ���̴߳�������ͻ�������
			/*
			 * �������˱����ܹ��������ϴ�����Ҳ����ûacceptһ���ͻ��˶��󣬾ʹ���һ���߳�������ͻ��˵�����
			 * web������������ô����(��Ϊtomcat�������ײ����ʹ��SocketServerд��),�����Ϳ���ʵ���ɵ������̴߳���ͻ������󣬴Ӷ�ʵ�ֲ�������
			 * */
			new Thread(new UploadImage(s)).start();
		}
		//ss.close();
	}
}
