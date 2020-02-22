package exer1;

public class MyRunnableTest {
	
	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			int i = 500;

			@Override
			public void run() {
				while (i > 0) {
					synchronized (this){
						notifyAll();
						if (i > 0) {
							System.out.println(Thread.currentThread().getName() + i--);

							try {
								wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t1 = new Thread(r,"====: ");
		Thread t6 = new Thread(r,"======: ");
		Thread t7 = new Thread(r,"========: ");
		Thread t2 = new Thread(r,"==========: ");
		Thread t8 = new Thread(r,"============: ");
		Thread t9 = new Thread(r,"==========: ");
		Thread t3 = new Thread(r,"========: ");
		Thread t0 = new Thread(r,"======: ");
		Thread t4 = new Thread(r,"===: ");
		Thread t5 = new Thread(r,"=: ");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t0.start();
		/*MyRunnable m1 = new MyRunnable();
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m1);
		t1.setName("1: ");
		t2.setName("2: ");
		t1.start();
		t2.start();*/
	}
}
class MyRunnable implements Runnable{
	int i = 0;
	@Override
	public synchronized void run() {
		notify();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(i <= 100){
			System.out.println(Thread.currentThread().getName() + i);
			i++;
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}