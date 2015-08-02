package cn.lnu.net.udp.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//����������ͨ��UDPsocket��������
public class Send implements Runnable {
	//�������һ��������Ҫsocket����������ݵķ���
	private DatagramSocket ds;
	public Send(DatagramSocket ds){
		super();
		this.ds=ds;
	}
	public void run() {
		//����ķ������ݵ���������
		//1��Ҫ���͵����������������¼��
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//1.1��ȡ����
			String line=null;
			try {
				while((line=br.readLine())!=null){
					
					//1.2�����ݱ���ֽ�����
					byte[] buf=line.getBytes();
					//2�������ݷ�װ�����ݰ���
					DatagramPacket dp=new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),10000);
					//3�������ݰ����ͳ�ȥ
					ds.send(dp);
					
					if("over".equals(line)){
						break;
					}
				}
			ds.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
