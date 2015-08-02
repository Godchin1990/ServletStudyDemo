package cn.lnu.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPRecvDemo {

	/**
	 * ����UDP�Ľ��ն�
	 * ˼·��
	 * 1������socket���񣬲���ȷһ���������˶˿ڣ���ʾ�ڸö˿��ϼ�������
	 * 2��������
	 * 3������������Ҫ������ȡ������ip��data,�˿�
	 * 4���ر���Դ
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("UDP��������������...");
		//1����socket����
		DatagramSocket ds=new DatagramSocket(8000);
		//2��ʹ��socket�Ľ��շ�������������,��Ҫ���յ������ݴ洢�����ݰ���
		//����ͨ�����ݰ�����ķ������յ������ݽ��н���
			//2.1����һ�����ݰ�
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		ds.receive(dp);//����ʽ����
		//3��ͨ�����ݰ���������յ������ݣ�ʹ�����ݰ��ķ���
		String from_ip=dp.getAddress().getHostAddress();
		int port=dp.getPort();
		//����ı�����
		String data=new String(dp.getData(),0,dp.getLength());
		System.out.println(from_ip+":"+port+" has send "+data);
		//4���ر���Դ
		ds.close();
	}

}
