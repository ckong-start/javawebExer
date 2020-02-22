package LambdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Test4 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("adf", "ddf", "ger", "bxb");

		/*
		 * ArrayList<String> list = new ArrayList<String>();
		 * Collections.addAll(list, "adf", "ddf", "ger", "bxb");
		 */

		Supplier<ArrayList<String>> s = () -> {
			ArrayList<String> newList = new ArrayList<String>();
			for (int i = 0; i < 3; i++) {
				String str = list.get(i);
				newList.add(str);
			}
			return newList;
		};
		System.out.println(s.get());
	}

	/*
	 * ArrayList<String> al = method(() -> { ArrayList<String> newList = new
	 * ArrayList<String>(); for (int i = 0; i < 3; i++) { String s =
	 * list.get(i); newList.add(s); } return newList; }); al.forEach(t ->
	 * System.out.println(t));
	 * 
	 * }
	 */

	public static ArrayList<String> method(Supplier<ArrayList<String>> s) {
		return s.get();
	}
}
