package part2;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		
	}
}
class CircleQueue{
	private int maxSize;
	//front指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，初始值为0
	private int front;
	//rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定，初始值为0；
	private int rear;
	private int[] arr;
	
	public CircleQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}
	public boolean isFull(){//判断队列是否满
		return (rear + 1) % maxSize == front;
	}
	
	public boolean isEmpty() {//判断队列是否为空
		return front == rear;
	}
	
	public void addQueue(int num) {//添加数据到队列
		//判断队列是否满
		if(isFull()) {
			System.out.println("队列满，不能加入数据~");
			return;
		}
		//添加数据
		arr[rear] = num;
		rear = (rear + 1) % maxSize;
	}
	
	public int getQueue() throws Exception {//获取队列的数据，出队列
		if(isEmpty())
			throw new Exception("队列已空~~");
		//这里需要分析出front是指向队列的第一个元素
		//1.先把front对应的值保留到一个临时变量
		//2.将front后移，考虑取余
		//3.将临时保存的变量返回
		int num = arr[front];
		front = (front + 1) % maxSize;
		return num;
	}
	
	public void showQueue() {//显示队列的所有数据
		if(isEmpty()) {
			System.out.println("队列为空~~");
			return;
		}
		for(int i = front; i < front + size() ; i++) {
			System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
		}
	}
	private int size() {//有效数据的个数
		return (rear - front + maxSize) % maxSize;
	}
	
	public int headQueue() throws Exception {//显示队列的头数据，注意不是取出数据
		if(isEmpty())
			throw new Exception("队列已空~~");
		return arr[front];
	}
}