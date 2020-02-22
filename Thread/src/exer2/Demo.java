package exer2;

import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		BaoZi bz = new BaoZi();
		ChiHuo ch = new ChiHuo("吃货1", bz);
		ChiHuo ch1 = new ChiHuo("吃货2", bz);
		ChiHuo ch2 = new ChiHuo("吃货3", bz);
		BaoZiPu bzp = new BaoZiPu("包子铺1", bz);
		ch.start();
		ch1.start();
		ch2.start();
		bzp.start();
	}
}

class BaoZi {
	String pier;
	String yaner;
	boolean flag = false;
}

class ChiHuo extends Thread {
	private BaoZi bz;

	public ChiHuo(String name, BaoZi bz) {
		super(name);
		this.bz = bz;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (bz) {
				if (bz.flag == false) {
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "正在吃" + bz.pier + bz.yaner + "的包子");
				bz.notifyAll();
				bz.flag = false;
			}
		}
	}
}

class BaoZiPu extends Thread {
	private BaoZi bz;
	private Random ran = new Random();

	public BaoZiPu(String name, BaoZi bz) {
		super(name);
		this.bz = bz;
	}

	public void run() {
		while (true) {
			synchronized (bz) {
				if (bz.flag == true) {
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("包子铺开始做包子");
				switch (ran.nextInt(4)) {
				case 0:
					bz.pier = "冰皮";
					bz.yaner = "五仁";
					break;
				case 1:
					bz.pier = "薄皮";
					bz.yaner = "牛肉大葱";
					break;
				case 2:
					bz.pier = "灌汤";
					bz.yaner = "鲜肉";
					break;
				case 3:
					bz.pier = "个小";
					bz.yaner = "荠菜肉";
					break;
				}
				bz.flag = true;
				System.out.print(bz.pier + bz.yaner + "的包子造好了,");
				System.out.println("吃货来吃吧");
				bz.notify();
			}
		}
	}
}