package cn.lnu.string.demo;

public class StringDemo2 {

	/**
	 * �Ӵ��������г��ֵĴ�����"nbafhafnbajfknbajfal';hnbajfanba"
	 * 
	 * ˼·��
	 * 1����Ҫ����
	 * 2���ҵ�һ��nba�ͼ���
	 * 3��������ַ����в������ַ���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="nbafhafnbajfknbajfal';hnbajfanba";
		String key="nba";
		int count=getKeyCount(str,key);
		System.out.println("key count="+count);
	}

	public static int getKeyCount(String str, String key) {
		int count=0;
		int pos=0;
		while((pos=str.indexOf(key,pos))!=-1){
			count++;
			//ÿ������һ�Σ���Ҫȷ���´�Ҫ�ҵ���ʼλ�ã��ϴ�λ��+key�ĳ���
			pos+=key.length();
		}
		return count;
	}

}
