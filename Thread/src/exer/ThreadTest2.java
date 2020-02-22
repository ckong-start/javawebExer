package exer;
/*
 * 1)启动两个线程对一个数字i操作
 * 2)其中1个线程每次对i加1
 * 3)另1个线程每次对i减一
 * 4)各运行20次，结果i的值等于初始值。
*/
public class ThreadTest2 {
	public static void main(String[] args) {
		Task task = new Task();
		new Thread() {
			public void run() {
				
					task.task1();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread() {
			public void run() {
				
					task.task2();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}

class Task {
	int i = 0;

	public void task1() {

		for (int m = 0; m < 20; m++) {
			i += 1;
			System.out.println(Thread.currentThread().getName() + " : " + i);

		}
		
		
	}
	public void task2(){
		
		for (int n = 0; n < 20; n++) {
			i -= 1;
			System.out.println(Thread.currentThread().getName() + " : " + i);

		}
		
	}
}