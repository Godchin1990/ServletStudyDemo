package cn.lnu.net.tcp.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadTextClient {

	/**
	 * ʵ�ֿͻ����ı��ϴ�
	 * �ϴ��ı��Ŀͻ��ˣ���ȡ�����ı����ݣ����͸��������ˣ�����˽�����Ϻ󣬻������ϴ��ɹ�"����
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("�ϴ��ı��ͻ�������...");
		Socket s=new Socket("127.0.0.1",10005);
		//1��ȷ������Դ�������ı��ļ�
		BufferedReader bufr=new BufferedReader(new FileReader("client.txt"));//FileReader���Զ�ȡ�ַ�/�ı��ļ���BufferedReaderΪ��װ������ÿ�ζ�ȡһ���ı�
		//2��ȷ��Ŀ�ģ�socket�������
		//BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//��ÿ�ζ�ȡ�����ַ�������ת��֮��д���ֽ����У��ڲ�������ʵ���ַ������ֽ�����ת����Ϊ�˷��㣬ÿ��дһ�У�ʹ��BufferedWriter��װ��
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);//printWriter����ʵ��ԭ���ı����ݵ����������ʲô��дʲô��Ϊ�˱�֤�Զ�ˢ�£����ڶ�����������Ϊtrue
		String line=null;
		while((line=bufr.readLine())!=null){
			out.println(line);
		}
		//Ϊ�˸��߷������ļ�������ϣ������������ͽ�����ǣ����ǵ�һ�ַ�ʽ
		//out.println("over");//���׳����ظ�������ļ��д˱�ǵĻ�
		//�ڶ��ַ�ʽ��ʹ��socket�Ľ������������������������ڿͻ��˷�������֮�󣬵��ø÷��������߷����������ݷ�����ϣ��ڲ����һ��������ǹ�ȥ
		s.shutdownOutput();
		//3,ͨ��socket��ȡ����ȡ�������˷��ص�����
		BufferedReader bufIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String lineIn=bufIn.readLine();
		System.out.println(lineIn);
		
		//4���ر���Դ
		bufr.close();
		s.close();
	}

}
