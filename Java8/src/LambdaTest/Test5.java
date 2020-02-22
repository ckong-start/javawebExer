package LambdaTest;

import java.util.function.Function;

public class Test5 {

	public static void main(String[] args) {
		Function<String, Integer> f = t -> Integer.parseInt(t);
		System.out.println(f.apply("123"));
	}
	/*
	 * method("123", t -> Integer.parseInt(t)); }
	 */

	public static void method(String str, Function<String, Integer> f) {
		int a = f.apply(str);
		System.out.println(a);
	}
}
