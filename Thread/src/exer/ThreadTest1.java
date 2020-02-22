package exer;



public class ThreadTest1 {
	public static void main(String[] args) {
		myThread1 m1 = new myThread1();
		myThread2 m2 = new myThread2();
		/*System.out.println(m1);
		System.out.println(m2);*/
		Thread t1 = new Thread(m2);
		m1.setName("继承类 (奇数)： ");
		t1.setName("实现接口(偶数) ： ");
		m1.start();
		t1.start();
	}
}
class myThread1 extends Thread{
	
	@Override
	public void run() {//打印奇数
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0;i < 100;i++){
			if(i % 2 == 1)System.out.println(Thread.currentThread().getName() + i);
		}
	}
}
class myThread2 implements Runnable{

	@Override
	public void run() {//打印偶数
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0;i < 100;i++){
			if(i % 2 == 0)System.out.println(Thread.currentThread().getName() + i);		
		}
	}
}