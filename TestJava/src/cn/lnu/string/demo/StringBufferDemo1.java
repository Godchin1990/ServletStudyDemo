package cn.lnu.string.demo;

public class StringBufferDemo1 {

	/**
	 * StringBuffer:�ַ���������
	 * ��Ϊһ���ַ�����
	 * �ص㣺
	 * 1�����ȿ��Ա仯
	 * 2�����Զ�����ͨ��ָ���ķ��������޸�
	 * 3����������һ�㶼��߱��������е�Ԫ�ؽ��в����Ĺ��ܣ�����˵��ɾ�Ĳ�
	 * 4�����������Դ洢��ͬ���͵�����
	 * 5,���ջ������洢������ݶ������ַ�������ֻ������ʱ�洢������
	 */
	public static void main(String[] args) {
		String str="a"+4+'c';
		//���ڴ��еĹ��̣�1������һ���ַ�����������2�ѽ�Ҫ����ַ�����Ԫ���ȴ洢������3����󽫻�����������ݱ���ַ���
		str=new StringBuffer().append("a").append(4).append('c').toString();
		
		
	}

}
