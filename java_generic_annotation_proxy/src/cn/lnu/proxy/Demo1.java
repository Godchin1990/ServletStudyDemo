package cn.lnu.proxy;

public class Demo1 {

	/**
	 * �Ҵ��糪�裬������Ҫ��������������������֮�����ҪǮ��������ȥ������ʵ����ķ���ȥ��������
	 * @param args
	 */
	public static void main(String[] args) {
		LiyuchunProxy proxy=new LiyuchunProxy();//����������������Ĵ������
		Person person=proxy.createProxy();//����������ͨ�����������������Ĵ����������ֵ��������Ĵ����������ض������ֱ�ӷ���
		
		String singres=person.sing("����һ����");//ʵ�ʵ��õĴ������е�invoke����
		String danceres=person.dance("�ֹ���");
		
		System.out.println(singres+"  "+danceres);
	}

}
