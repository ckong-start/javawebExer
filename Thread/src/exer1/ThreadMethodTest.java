package exer1;

public class ThreadMethodTest {
	public static void main(String[] args){
		/*Thread t1 = new Thread();
		Thread t2 = new Thread("线程一");
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		
		Thread t3 = Thread.currentThread();
		System.out.println(t3);
		for(int i = 1;i <= 10;i++){
			System.out.println(i);
			Thread.sleep(1000);
		}*/
		
		MyThread0 m1 = new MyThread0("线程一");
		MyThread0 m2 = new MyThread0("线程二");
		MyThread0 m3 = new MyThread0("线程三");
		m1.start();
		m2.start();
		m3.start();
		
	}
}
class MyThread0 extends Thread{
	
	private int i = 0;


	public MyThread0() {
		super();
	}

	public MyThread0(String name) {
		super(name);
	}

	public void run() {
		synchronized (MyThread0.class) {
			while (i < 100) {
				
				System.out.println(getName() + i);
				i++;
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
