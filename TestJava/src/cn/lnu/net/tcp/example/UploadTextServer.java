package cn.lnu.net.tcp.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadTextServer {

	/**
	 * �ϴ��ı��ķ���ˣ������ı����ݣ����洢���ļ��У�������������Ϻ󣬻������ϴ��ɹ�������
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�ϴ��ı�������������...");
		//1������˶���
		ServerSocket ss=new ServerSocket(10005);
		//2����ȡ�ͻ���socket
		Socket s=ss.accept();
		String client_ip=s.getInetAddress().getHostAddress();
		System.out.println(client_ip+".....connected!");
		//3����ȡ��ȡ����ȷ��Դ������socket
		BufferedReader bufIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		//4��ȷ��Ŀ�ģ����������ļ�
		PrintWriter pw=new PrintWriter(new FileWriter("server.txt"));//PrintWriter������ʲôʲôдʲô
		//5��Ƶ����д
		String line=null;
		while((line=bufIn.readLine())!=null){
			/*if("over".equals(line)){
				break;
			}*/
			pw.write(line);
		}
		
		//6�����ͻ��˷�����Ϣ
		//BufferedWriter out=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		out.println("�ϴ��ɹ�");
		//out.write("�ϴ��ɹ�");
		
		//7���ر���Դ
		pw.close();
		s.close();
		ss.close();
	}

}
