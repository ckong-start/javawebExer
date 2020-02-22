package LambdaTest;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * B<Integer> b = (x, y) -> x + y; 
		 * System.out.println(b.demo2(5, 6)); }
		 */
		method(5, 6, (t1, t2) -> t1 + t2);
		method(5.0, 6.1, (t1, t2) -> t1 + t2);
	}

	public static <E> void method(E x, E y, B<E> b) {
		E demo2 = b.demo2(x, y);
		System.out.println(demo2);
	}
}

@FunctionalInterface
interface B<T> {
	T demo2(T x, T y);
}