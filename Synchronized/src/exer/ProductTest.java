package exer;
/*
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 */

class Clerk {
	private int product;

	// 生产产品
	public synchronized void produceProduct() {
		if (product < 20) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			product++;
			System.out.println(Thread.currentThread().getName() + "生产了第" + product + "件产品");
			notifyAll();
		} else
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	// 销售产品
	public synchronized void consumeProduct() {
		if (product > 0) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "购买了第" + product + "件产品");
			product--;
			notify();
		} else
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
}

class Consume extends Thread {//消费者
	private Clerk clerk;

	public Consume(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
        System.out.println(getName() + ":开始消费产品.....");
		while (true) {
			clerk.consumeProduct();
		}
	}
}

class Productor extends Thread {//生产者
	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
        System.out.println(getName() + ":开始生产产品.....");
		while (true) {
			clerk.produceProduct();
		}
	}
}

public class ProductTest {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Consume c1 = new Consume(clerk);
		c1.setName("消费者1");
		Consume c2 = new Consume(clerk);
		c2.setName("消费者2");
		Productor p1 = new Productor(clerk);
		p1.setName("生产者");
		c1.start();
		c2.start();
		p1.start();
	}
}
