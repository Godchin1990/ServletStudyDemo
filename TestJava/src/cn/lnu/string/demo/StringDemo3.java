package cn.lnu.string.demo;

public class StringDemo3 {

	/**
	 * �������ַ����������ͬ�Ӵ�
	 * "sadfcctvghjkl"
	 * "zxcctvcv"
	 * 
	 * ˼·��
	 * 1���Զ̵��ַ���Ϊ�����������ַ������ж��Ƿ���ڣ�������ڣ����ҵ�������
	 * 2�����û���ҵ������̵��ַ����ĳ��ȵݼ���ȡ�Ӵ������ڳ��Ĵ��в��ң�ֻҪ�ҵ��ͽ�����
	 * 3��û���ҵ���˵��û����ͬ��
	 */
	public static void main(String[] args) {
		String str="sadfcctvghjkl";
		String str2="zxcctvcv";
		String maxSubString=getMaxSubString(str,str2);
		System.out.println("����Ӵ��ǣ�"+maxSubString);
	}

	public static String getMaxSubString(String s1, String s2) {
		String longStr,shortStr;
		longStr=s1.length()>s2.length()?s1:s2;
		shortStr=s1.equals(longStr)?s2:s1;
		//�Զ̵��ַ����������Ӷ̴���ȡ�Ӵ��������ַ������жϣ��Ƿ���ڡ�
		for(int x=0;x<shortStr.length();x++){
			for(int y=0,z=shortStr.length()-x;z<=shortStr.length();y++,z++){
				//����y��z��ȡ�Ӵ�
				String temp=shortStr.substring(y, z);
				//System.out.println(temp);
				if(longStr.contains(temp)){
					return temp;
				}
			}
		}
		return null;
	}

}
