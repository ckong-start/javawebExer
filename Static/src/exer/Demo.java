package exer;

class Something {
	public static void main(String[] args) {
		Demo s = new Demo();
		System.out.println("return " + doSomething());
	}
	public static String doSomething(){
		return "DO something...";
	}
}
public class Demo {
	private static int j = 0;

	private static boolean methodB(int k) {
		j += k;
		return true;
	}

	public static void methodA(int i) {
		boolean b;
		b = i < 10 | methodB(4);
		b = i < 10 || methodB(8);
	}

	public static void main(String args[]) {
		methodA(0);
		System.out.println(j);
	}
}
