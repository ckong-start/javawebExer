package exer.threadlocal;

import java.util.Random;

public class ThreadLocalTest {
	static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
	static Random random = new Random();
	
	static class Task implements Runnable {

		@Override
		public void run() {
			int num = random.nextInt(100);
			String threadName = Thread.currentThread().getName();
			System.out.println("线程[" + threadName + "] 生成的随机数是：" + num);
			threadLocal.set(num);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Order().createOrder();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Object object = threadLocal.get();
			System.out.println("线程[" + threadName + "] 中取出随机数是：" + object);
		}
		
	}
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Task()).start();
		}
	}
}

class Order{
	public void createOrder() {
		System.out.println(Thread.currentThread().getName()
				+ " : 从Order中取当前线程的num是："
				+ ThreadLocalTest.threadLocal.get());
		new OrderDao().saveOrder();
	}
}
class OrderDao{
	public void saveOrder() {
		System.out.println(Thread.currentThread().getName()
				+ " : 从OrderDao中取当前线程的num是："
				+ ThreadLocalTest.threadLocal.get());
		new OrderService().updateOrder();
	}
}
class OrderService{
	public void updateOrder() {
		System.out.println(Thread.currentThread().getName()
				+ " : 从OrderService中取当前线程的num是："
				+ ThreadLocalTest.threadLocal.get());		
	}
}
