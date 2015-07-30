package cn.lnu.thread;

public class SellTickets implements Runnable {
	private int tickets = 200;
	private Object obj = new Object();

	public void run() {

		while (true) {
			synchronized (obj) {//����������������
				if (tickets > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getId() + ":"
							+ Thread.currentThread().getName()
							+ " is selling ticket " + tickets--);
				}
			}

		}
	}
}
