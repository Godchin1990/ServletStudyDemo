package cn.lnu.string.demo;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] keywords = {"΢��", "�����", "����"};
		String[] text = {"΢��", "����", "�о�Ժ", "����", "��", "1998", "��", "��", "����",
				"��", "ʹ��", "��", "ʹ", "δ��", "��", "�����", "�ܹ�", "��", "��", "��",
				"��", "ѧ", "��", "��", "��", "��Ȼ����", "��", "����", "����", "����", "��",
				"��", "��", "����", "��", "��", "΢��", "����", "�о�Ժ", "��", "��", "�ٽ�",
				"�����", "��", "��̫", "����", "��", "�ռ�", "��", "����", "��̫", "�û�", "��",
				"����", "����", "��" };
		//String[] keywords2={"΢��","�����","����"};
		String[] keywords2=keywords;
		System.out.println("keywords VS text in hashcode:"+(keywords.hashCode()==text.hashCode()));
		System.out.println("keywords VS keywords2 in hashcode:"+(keywords.hashCode()==keywords2.hashCode()));
		System.out.println("<--------------------------------->");
		String s = new String("sb");
		String ss = new String("sb");
		String s2="sb";
		System.out.println("s VS ss in hashcode:"+(s.hashCode()==ss.hashCode()));
		System.out.println("s VS s2 in hashcode:"+(s.hashCode()==s2.hashCode()));
	}

}
