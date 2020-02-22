package exer1;

public class TestSynMethod {
	
	public static void main(String[] args) {
		MyRunnable12 m = new MyRunnable12();
		Thread t1 = new Thread(m,"线程一");
		Thread t2 = new Thread(m,"线程二");
		t1.start();
		t2.start();
		
	}
}

class MyRunnable12 implements Runnable{
	int i = 0;
	@Override
	public void run() {
		while(i <= 100){
			method();
		}
	}
	private synchronized void method() {
		notify();
		if(i < 100){
			System.out.println(Thread.currentThread().getName() + ": " + i++);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}