package cn.lnu.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	/**
	 * tcp�ͻ��˵Ľ���
	 * ˼·��
	 * 1������tcp�ͻ��˷���
	 * 	 1.1��Ϊ���������ӣ����������Ӳſ��Խ���ͨ��
	 * 	 1.2�ڴ����ͻ���ʱ���ͱ�����ȷĿ�ĵ�ַ�Ͷ˿�
	 * 
	 * 2��һ�����ӽ����������˴������ݵ�ͨ�����Ϳ�����ͨ���н������ݴ����ˡ�
	 * ���������ʵ����ͨ����ʵ�ֵģ����������Socket IO����
	 * 3��ֻҪ��ȡ��Socket IO���е�д�����Ϳ��԰�����д��socket���з���������
	 * 4���ر���Դ
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("TCP�ͻ�������...");
		//1�������ͻ��˶�����ȷĿ�ĵ�ַ�Ͷ˿�
		Socket s=new Socket("127.0.0.1",10001);
		//2�����socket���е�������������ݷ��͸�������
		OutputStream out=s.getOutputStream();
		//3��ͨ�������д����
		out.write("ע���ˣ�tcp����Ҫ����".getBytes());
		
		//4���ر���Դ
		s.close();
	}

}
