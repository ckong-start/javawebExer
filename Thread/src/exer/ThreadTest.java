package exer;

//利用多线程设计一个程序，同时输出 50 以内的奇数和偶数，以及当前运行的线程名。
public class ThreadTest {
	public static void main(String[] args) {
		myThread t1 = new myThread();
		myThread t2 = new myThread();
		t1.setName("-奇数");
		t2.setName("--偶数");
		t1.k = 1;
		t1.start();
		t2.start();
	}
}

class myThread extends Thread {

	int k = 0;

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (k <= 50) {
			System.out.println(Thread.currentThread().getName() + " : " + k);
			k += 2;
		}
	}
}