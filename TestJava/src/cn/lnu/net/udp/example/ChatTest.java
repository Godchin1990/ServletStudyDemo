package cn.lnu.net.udp.example;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatTest {

	/**
	 * ͨ��UDPЭ��
	 * ���һ���������
	 * һ�����������ݵ�����һ������������ݵ���������������Ҫͬʱִ��
	 * ����ʹ�ö��̼߳���
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws SocketException {
		// TODO Auto-generated method stub
		//1,����socket����
		DatagramSocket send=new DatagramSocket(8888);
		DatagramSocket recv=new DatagramSocket(10000);
		new Thread(new Send(send)).start();
		new Thread(new Recv(recv)).start();
	}

}