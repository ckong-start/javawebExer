package listexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add("abc");
		coll.add(false);
		Iterator iterator = coll.iterator();
		//next()
		System.out.println(iterator.next());
		
		//hasnext()
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("========================");
		//remove()
		iterator = coll.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if ("abc".equals(obj)) {
				iterator.remove();
			}
		}
		iterator = coll.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
}
