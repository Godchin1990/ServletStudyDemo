package cn.lnu.net.tcp.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	/**ʵ�ֿͻ���������������ݽ���
	 * ���󣺿ͻ��˷������ݸ�������������ȡ�������˷���������
	 * 1,����socket�ͻ���
	 * 2����ȡsocket�������д����
	 * 3����ȡsocket�Ķ�ȡ������ȡ�������˷��ص�����
	 * 4�ر���Դ
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("tcp�ͻ�������...");
		//1������socket�ͻ���
		Socket s=new Socket("127.0.0.1",10004);
		//2,��ȡsocket�������д����
		OutputStream out=s.getOutputStream();
		out.write("������,�ͻ�������Ҫ����".getBytes());
		//3,��ȡsocket�Ķ�ȡ������ȡ�������˷��ص�����
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		len=in.read(buf);
		String data=new String(buf,0,len);
		System.out.println(data);
		//4���ر���Դ
		s.close();
	}

}
