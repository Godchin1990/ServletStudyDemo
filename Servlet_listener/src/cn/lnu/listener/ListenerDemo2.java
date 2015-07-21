package cn.lnu.listener;
//�۲������ģʽ��Observer���ģʽ����demo1����ʾ�����������¼������Ϸ����ļ����¼�������ֻ��Ҫд�¼��������༴��Ȼ��ע����¼�Դ��
//Ҳ����˵demo1����ʾ�Լ�д����������ȥ�������˵Ķ����Ϸ�������Ϊ�������demo2����ʾ�����Լ����һ���¼������뱻���˼����������Ҫʹ�ù۲������ģʽ��

class Person{//����˵���һ������Ҫ�����˼���,Ҳ����������������������������������Ҫ�����˼�����������Ҫ��������������������ע��һ��������
	
	private PersonListener listener;//����һ��������ס���ݽ������¼�������
	
	public void run(){
		if(listener!=null){//�ж��˼���û�д��ݼ������������紫�ݽ�����,���ڵ���run����֮ǰ���ȵ����¼��������Ķ�Ӧ�����ȴ��������������
			Event e=new Event(this);
			this.listener.dorun(e);
		}
		System.out.println("run");
	}
	
	public void eat(){
		if(listener!=null){
			Event e=new Event(this);
			this.listener.doeat(e);
		}
		System.out.println("eat");
	}
	
	public void registerListener(PersonListener listener){//��������������������ע��һ���������������˵����������������¼�����������������¼�Դ������õģ�֮���¼�Դ����������������¼��������ķ�����������ǻ���Ҫ���Ⱪ¶һ���ӿ�
		this.listener=listener;
	}
}
/*����������ϵ����������뱻�˼������Ͷ��Ⱪ¶һ�����Ӧ�Ľӿڣ�������Ҫ�������������Ҫʵ������ӿڣ����൱�ڴ���һ����������Ȼ���ڸö�����ע����ʵ������ӿڵ��¼���������
 * �����������ע�������֮�����������ͻ��ڴ�����Ӧ�ķ���֮ǰ��ȥ���ü������ķ������д���Ȼ����ȥ�������������ķ�����
 * */
interface PersonListener{//����ʵ������ӿڣ����൱��д�˸��¼�������
	public void dorun(Event e);
	
	public void doeat(Event e);
}

//�������һ���¼�������Ҫ���ڷ�װ�¼�Դ
class Event{
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Person person) {
		super();
		this.person = person;
	}
	
	
	
}
