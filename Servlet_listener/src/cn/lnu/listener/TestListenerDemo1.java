package cn.lnu.listener;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//
public class TestListenerDemo1 {

	/**
	 *�����⣺������һ��java�¼��������ƣ�
	 *1.java���¼����������漰������������¼�Դ���¼����������¼�����
	 *2.���¼�Դ�Ϸ�������ʱ������������¼���������һ�������������ڵ����������ʱ���ᴫ���¼��������
	 *3.�¼��������п�����Ա��д��������Ա���¼��������У�ͨ���¼���������õ��¼�Դ���Ӷ����¼�Դ�ϵĲ������д���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame();
		f.setSize(400, 400);
		f.setVisible(true);
		
		f.addWindowListener(new myListener());//���¼�Դע�������
	}

}

class myListener implements WindowListener{//�¼���������

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {//e���ݹ����¼�Դ�ϴ����¼�ʱ�����ݹ������¼�����
		// TODO Auto-generated method stub
		Frame f=(Frame) e.getSource();
		f.dispose();
		System.out.println("���ڱ��رգ�");
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent e) {//��С��
		// TODO Auto-generated method stub
		Frame f=(Frame) e.getSource();
		System.out.println("��С���¼���������");
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}