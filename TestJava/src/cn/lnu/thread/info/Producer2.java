package cn.lnu.thread.info;
//������
public class Producer2 implements Runnable {
	private Resource2 r2;//���Զ������߶�������
	public Producer2(Resource2 r2){
		this.r2=r2;
	}
	public void run() {
		while(true)
			r2.setRes("���");
	}

}
