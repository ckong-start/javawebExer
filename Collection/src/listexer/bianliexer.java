package listexer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class bianliexer {
	
	@Test
	public void test(){
		List<String> list = new ArrayList<>();
		list.add("avv");
		list.add("fds");
		list.add("trh");
		list.add("jjh");
		list.add("iop");
		list.add("bnm");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("=============================");
		for (String string : list) {
			System.out.println(string);
		}
	}
}
