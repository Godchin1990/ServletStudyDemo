package cn.lnu.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {

	/**
	 * ���󣺽���udp�ķ��Ͷ�
	 * ˼·��
	 * 1����������ʵ��udp�����socket����
	 * 2����ȷ���巢�͵�����
	 * 3��ͨ��socket���񽫾�������ݷ��ͳ�ȥ
	 * 4���رշ���
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("UDP���Ϳͻ�������...");
		//1������udp����
		DatagramSocket ds=new DatagramSocket(8888);//ָ��һ�����Ͷ˶˿ڣ�Ҳ���Բ�ָ���������������ݵĶ˿��������
		//2����ȷ����
		String str="ע���ˣ�UDP����Ҫ����";
		//3���������ݣ��Ƚ����ݷ�װ�����ݰ���
			//3.1�����ݷ�װ�����ݰ������У����ݰ�����ȷĿ�ĵ�ַ�Ͷ˿�
		byte[] buf=str.getBytes();
		int length=buf.length;
		DatagramPacket dp=new DatagramPacket(buf,length,InetAddress.getByName("127.0.0.1"),8000);
			//3.2�������ݰ�
		ds.send(dp);
		
		//4,�رշ���
		ds.close();
		
	}

}
