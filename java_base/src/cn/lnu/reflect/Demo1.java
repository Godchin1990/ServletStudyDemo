package cn.lnu.reflect;

public class Demo1 {

	/**
	 * java���䣬�����࣬����ָ������ֽ���Class���󣬰����˸����������Ϣ
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		//���ַ�ʽ����ָ���෵��ָ����װ��ָ����ȫ����Ϣ���ֽ������
		//1.
		Class clazz=Class.forName("cn.lnu.reflect.Person");//ʹ�÷������person�࣬���ط�װ������Ϣ���ֽ�����󣬸����Ĳ�������������������ƣ��൱�ڰ�Ӳ����Person����ֽ�����ص��ڴ���
		//System.out.println(clazz);//class cn.lnu.reflect.Person
		//2.
		Class clazz1=new Person().getClass();
		//System.out.println(clazz1);//class cn.lnu.reflect.Person
		//3.
		Class clazz2=Person.class;
		System.out.println(clazz2);//class cn.lnu.reflect.Person
	}

}
