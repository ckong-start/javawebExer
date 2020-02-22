package exer1;

public class TicketTest {

	public static void main(String[] args) {
		MyRunnable15 mr = new MyRunnable15();
		Thread t1 = new Thread(mr,"窗口一");
		Thread t2 = new Thread(mr,"窗口二");
		t1.start();
		t2.start();
	}
}
class MyRunnable15 implements Runnable{
	int ticket = 100;
	@Override
	public void run() {
		while(ticket > 0){
			method();
		}
	}
	private synchronized void method() {
		if(ticket > 0){
			System.out.println(Thread.currentThread().getName() + 
					"正在卖第" + ticket-- + "票");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}