package exer;

public class Test {

	static int x, y, z;

	static {
		int x = 5;//此处x为重新定义的变量
		x--;
		//System.out.println("1- " + x);
	}

	static {
		x--;
		//System.out.println("2- " + x);
	}

	public static void main(String[] args) {
		System.out.println("x=" + x);
		z--;
		//System.out.println("4- " + z);
		method();
		System.out.println("result:" + (z + y + ++z));
	}

	public static void method() {
		y = z++ + ++z;//y = -1 + 1
		//System.out.println("5- " + z);
		//System.out.println("6- " + y);
	}
}
