package exer;

public class Test1 {
	public static void main(String[] args) {

		Test1 StringAsParamOfMethodDemo = new Test1();

		StringAsParamOfMethodDemo.testA();
	}

	private void testA() {

		String originalStr = "original";

		System.out.println("Test A Begin:");

		System.out.println("The outer String: " + originalStr);

		simpleChangeString(originalStr);

		System.out.println("The outer String after inner change: " + originalStr);

		System.out.println("Test A End.");

		System.out.println();
	}

	public void simpleChangeString(String original) {

		original = original + " is changed!";

		System.out.println("The changed inner String: " + original);
	}
}
