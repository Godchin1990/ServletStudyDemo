package cn.lnu.listener;
//���Թ۲���ģʽʵ�ֵ��Լ��������¼�Դ������Ҫ�����˼���
public class TestDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person();
		p.registerListener(new myListener1());
		
		p.eat();
		p.run();
	}
	
}

class myListener1 implements PersonListener{

	public void doeat(Event e) {
		// TODO Auto-generated method stub
		System.out.println(e.getPerson()+"����ô��֪���԰����������");
	}

	public void dorun(Event e) {
		// TODO Auto-generated method stub
		System.out.println(e.getPerson()+"������̫���˶��ˣ�");
	}
	
}