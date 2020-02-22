package LambdaTest;

import java.util.function.Predicate;

public class Test6 {

	public static void main(String[] args) {
		Predicate<String> p = t -> t.equals("abc");
		System.out.println(p.test("abc"));
	}
	/*
	 * boolean b = method(t -> t.equals("abc"), "abc"); System.out.println(b); }
	 */

	public static boolean method(Predicate<String> p, String str) {
		boolean b = p.test(str);
		return b;
	}
}
