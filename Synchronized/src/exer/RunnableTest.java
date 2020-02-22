package exer;

class MyThread implements Runnable {
	private int ticket = 1;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (ticket <= 100) {
					System.out.println(Thread.currentThread().getName() + "售票，票号为:" + ticket);
					ticket++;

				} else
					break;
			}
		}
	}

}

public class RunnableTest {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
		Thread t2 = new Thread(myThread);
		t1.setName("窗口1");
		t2.setName("窗口2");
		t1.start();
		t2.start();
	}
}
