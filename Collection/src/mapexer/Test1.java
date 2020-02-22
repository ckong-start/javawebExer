package mapexer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class Test1 {
	@Test
	public void test() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("AA", 123);
		map.put("45", 1234);
		map.put("BB", 56);
		map.put("CC", 123);
		// 方式一：entrySet()
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			System.out.println(entry.getKey() + "---->" + entry.getValue());
		}
		System.out.println();
		// 方式二：
		Set<String> keySet = map.keySet();
		Iterator<String> iterator2 = keySet.iterator();
		
		while (iterator2.hasNext()) {
			Object key = iterator2.next();
			Object value = map.get(key);
			System.out.println(key + "=====" + value);

		}
	}

}
