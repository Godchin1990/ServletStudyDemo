package cn.lnu.string.demo;

import java.util.Arrays;

public class StringDemo4 {

	/**
	 * ���ַ������ַ�������Ȼ˳������
	 * ˼·��
	 * 1��Ҫ����
	 * 2����ô�ܰ��ַ���ת�������أ�
	 * 3�����ַ������ҷ���
	 * 4������
	 * 5�����������������ַ���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="jbsahhavb";
		String sortString=sortChar(str);
		System.out.print(sortString);
	}

	public static String sortChar(String str) {
		//���ַ���ת���ַ�����
		char[] chs=str.toCharArray();
		//�������������
		sort(chs);
		//���ַ�����ת���ַ���
		return new String(chs);
	}

	public static void sort(char[] chs) {
		// TODO Auto-generated method stub
		Arrays.sort(chs);
	}

}
