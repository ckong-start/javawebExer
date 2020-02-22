package StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Test1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, "adf","dfa","jll","yui","rer");
		Stream<String> stream = list.stream();
		stream.forEach(t->System.out.println(t));
		System.out.println("===============================");
		stream = list.stream();
		stream.forEach(System.out::println);
	}
}
