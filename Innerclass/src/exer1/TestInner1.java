package exer1;

public class TestInner1 {
	public static void main(String[] args) {
		Outer1.Inner in = new Outer1.Inner();
		in.inMethod();
		Outer1.Inner.inTest();
	}
}

class Outer1 {
	private static int a = 1;
	private int b = 2;

	protected static class Inner {
		static int d = 4;// 可以

		void inMethod() {
			System.out.println("out.a = " + a);
		}

		static void inTest() {
			System.out.println("out.a = " + a);
		}
	}
}
