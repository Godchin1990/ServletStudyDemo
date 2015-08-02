package cn.lnu.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	/**
	 *����TCP��������
	 *˼·��
	 *1������socket�������˷��񣬷�������Ϊ���ÿͻ��˿��������ϣ������ṩ�˿ڣ�����������˿�
	 *2����ȡ�ͻ��˶���ͨ���ͻ��˵�socket���Ͷ�Ӧ�Ŀͻ��˽���ͨ��
	 *3����ȡ�ͻ��˵�socket���Ķ�ȡ��
	 *4����ȡ���ݣ�����ʾ�ڷ�������
	 *5���ر���Դ
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("TCP��������������...");
		//1�������������˶���
		ServerSocket ss=new ServerSocket(10001);
		//2����ȡ�ͻ��˶���
		Socket s=ss.accept();
		String fromip=s.getInetAddress().getHostAddress();
		System.out.println(fromip+"----connected!");
		
		//3,ͨ���ͻ��˶����ȡsocket���Ķ�ȡ��
		InputStream in=s.getInputStream();
		//4����ȡ�ͻ���socket���Ķ�ȡ����ȡ���ݣ�����ʾ
		byte[] buf=new byte[1024];
		
		int len=in.read(buf);
		String str=new String(buf,0,len);
		System.out.print(str);
		//5���ر���Դ
		s.close();//�ر����ӹ����Ŀͻ���
		ss.close();//�رշ�������
	}

}
