package listexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//随机存十个数，反转输出、从大到小输出
public class exercise1 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 100 + 1));
		}
		System.out.println(list);
		/*
		 * Collections.reverse(list); System.out.println(list);
		 */
		Collections.sort(list);
		System.out.println(list);
		System.out.println();
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println(list);
	}
}
