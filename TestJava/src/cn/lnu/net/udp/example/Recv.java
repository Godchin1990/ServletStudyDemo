package cn.lnu.net.udp.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//�����������
public class Recv implements Runnable {
	//�������һ��������Ҫsocket����������ݵĽ���
	private DatagramSocket ds;
	public Recv(DatagramSocket ds){
		super();
		this.ds=ds;
	}
	
	public void run() {
		while(true){
			//���յľ�����������
			//1�����յ��������ն���洢�����ݰ��У������ݰ��б������ֽ����顣
			byte[] buf=new byte[1024];
			//2���������ݰ�����
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			//3�����յ��������ݴ洢�����ݰ���
			try {
				ds.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//4����ȡ����
			String fromip=dp.getAddress().getHostAddress();
			String data=new String(dp.getData(),0,dp.getLength());
			System.out.println(fromip+":"+data);
			if("over".equals(data)){
				System.out.println(fromip+"-----�뿪��������");
			}
		}
		
	}

}
