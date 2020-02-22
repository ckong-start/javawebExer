package part2;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		//测试队列
		ArrayQueue queue = new ArrayQueue(5);
		char key = ' ';//用来接受用户的输入
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		//输出一个菜单
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = sc.next().charAt(0);
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("输出一个数");
				int num = sc.nextInt();
				queue.addQueue(num);
				break;
			case 'g':
				try {
					int result = queue.getQueue();
					System.out.println("取出的数据是：" + result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int result = queue.headQueue();
					System.out.println("队列头的数据是：" + result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				sc.close();
				loop = false;
				break;
			}
		}
		System.out.println("程序退出~");
	}
}
class ArrayQueue{
	private int maxSize;//最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//模拟队列
	
	public ArrayQueue(int arrMaxSize) {//构造器，指定最大长度的数组
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;//指向队列头部，分出front是指向队列头的前一个文职
		rear = -1;//指向队列尾，指向队列尾的数据（即队列最后一个数据）
	}
	
	public boolean isFull(){//判断队列是否满
		return rear == maxSize + 1;
	}
	
	public boolean isEmpty() {//判断队列是否为空
		return front == rear;
	}
	
	public void addQueue(int num) {//添加数据到队列
		if(isFull()) {
			System.out.println("队列满，不能加入数据~");
			return;
		}
		arr[++rear] = num;
	}
	
	public int getQueue() throws Exception {//获取队列的数据，出队列
		if(isEmpty())
			throw new Exception("队列已空~~");
		return arr[++front];
	}
	
	public void showQueue() {//显示队列的所有数据
		if(isEmpty()) {
			System.out.println("队列为空~~");
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i ,arr[i]);
		}
	}
	
	public int headQueue() throws Exception {//显示队列的头数据，注意不是取出数据
		if(isEmpty())
			throw new Exception("队列已空~~");
		return arr[front + 1];
	}
}