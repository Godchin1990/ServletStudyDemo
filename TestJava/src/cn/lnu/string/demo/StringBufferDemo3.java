package cn.lnu.string.demo;

public class StringBufferDemo3 {

	/**
	 * StringBuffer:�ַ���������
	 * ���������Զ����ݽ�����ʱ�洢
	 *  �˽⻺�����ĳ�������
	 *  ���Ԫ��
	 *  SttingBuffer append(������������);׷��
	 *  StringBuffer insert��index,�������͵����ݣ�;ָ��λ�����
	 *  
	 */
	public static void main(String[] args) {
		//1������һ������������
		StringBuffer sb=new StringBuffer();
		//2��׷��һ���ַ���
		sb.append("abc");
		//3������һ��booleanֵ��false
		sb.insert(1, false);//afalsebc---8
		System.out.println(sb+"---"+sb.length());//print�����Ὣ����Ҫ��ӡ��������ת���ַ�������������ڶ�����Զ�����toString����
		//4��ɾ���ַ�
		//sb.deleteCharAt(0);
		sb.delete(1, 4);//����ͷ������β
		System.out.println(sb+"---"+sb.length());//asebc---5
		
		//5���޸��ַ�
		sb.replace(1, 5, "what");
		
		System.out.println(sb+"---"+sb.length());//awhat---5
		sb.reverse();
		System.out.println(sb+"---"+sb.length());//tahwa---5
		
		/*
		 * �ַ�����������ά����һ�����ɱ䳤�ȵ����顱
		 * ���ͣ���ʵ���ǳ����ڲ����鳤�Ⱥ��½�����ĳ���Ҫ��ԭ���鳤�ȵ�1.5����1.75�ȱ�����
		 * ����ԭ��������ݸ��Ƶ��������У������µ�Ԫ��Ҳ��ӵ��������С�
		 * */
	}

}
