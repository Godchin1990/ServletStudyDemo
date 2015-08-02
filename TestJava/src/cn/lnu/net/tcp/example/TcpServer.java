package cn.lnu.net.tcp.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	/**ʵ�ֿͻ���������������ݽ���
	 * ���������յ��ͻ��˵����ݣ����������ݸ��ͻ��ˣ�Ӧ��
	 * 1��������������socket����
	 * 2����ȡ�ͻ��˶���socket
	 * 3����ȡ�ͻ��˶���socket�Ķ�ȡ��
	 * 4����ȡ�ͻ��˶���socket��д����
	 * 
	 * 5���ر���Դ
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Tcp������������...");
		//1,������������socket����
		ServerSocket ss=new ServerSocket(10004);
		//2,��ȡ�ͻ���socket����
		Socket s=ss.accept();
		String client_ip=s.getInetAddress().getHostAddress();
		System.out.println(client_ip+".....connected!");
		//3����ȡ�ͻ��˶���socket�Ķ�ȡ����
		InputStream in=s.getInputStream();
		byte buf[]=new byte[1024];
		int len=0;
		len=in.read(buf);
		String data=new String(buf,0,len);
		System.out.println(data);
		
		//4����ȡ�ͻ��˶���socket��д����
		OutputStream out=s.getOutputStream();
		out.write("�õ�,�㷢���������յ���".getBytes());
		
		//5���ر���Դ
		s.close();
		ss.close();
	}

}
