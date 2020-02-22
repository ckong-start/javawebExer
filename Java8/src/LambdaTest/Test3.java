package LambdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Test3 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("adf", "ddf", "ger", "bxb");
		/*list.forEach(t -> System.out.print(t + " "));
		System.out.println();
		Consumer<ArrayList<String>> c = t -> {
			for(String str : t){
				System.out.print(str + " ");
			}
		};
		c.accept(list);
	}*/	
		method(list, c -> {
			for (String str : c) {
				System.out.print(str + " ");
			}
		});
	}

	public static void method(List<String> list, Consumer<List<String>> c) {
		c.accept(list);
	}
}

