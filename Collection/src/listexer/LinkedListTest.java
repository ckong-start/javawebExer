package listexer;

import java.util.LinkedList;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);
		list.addFirst("开头");
		list.addLast("结尾");
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list);
	}
}
