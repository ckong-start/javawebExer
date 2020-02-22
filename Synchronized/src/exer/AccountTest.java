package exer;

import java.util.concurrent.locks.ReentrantLock;

//import java.util.concurrent.locks.ReentrantLock;

/* 
 * 银行有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * 共享数据为账户,多线程为储户
 * 账户有存钱的方法，储户调用存钱方法
 */
class Account {
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}
//	private static ReentrantLock lock = new ReentrantLock();
	// 同步方式一：
/*	public synchronized void deposit(double amt) {
		if (amt > 0) {
			balance += amt;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
		}
	}
*/	
	// 同步方式二：
	public void deposit(double amt) {
		synchronized (this) {
			notify();
			if (amt > 0) {
				balance += amt;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// 同步方式三：
/*	private static ReentrantLock lock = new ReentrantLock();

	public void deposit(double amt) {
		try {
			lock.lock();
			if (amt > 0) {
				balance += amt;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
			}
		} finally {
			lock.unlock();
		}
	}
*/
}

class Customer extends Thread {
	private Account acct;

	public Customer(Account acct) {
		this.acct = acct;

	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			acct.deposit(1000);
		}
	}

}

public class AccountTest {
	public static void main(String[] args) {
		Account acct = new Account(0);
		Customer c1 = new Customer(acct);
		Customer c2 = new Customer(acct);
		c1.setName("储户一");
		c2.setName("储户二");
		c1.start();
		c2.start();
	}
}
