package mapexer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapMethodTest {
	@Test
	public void test(){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("杨过", 23);
		map.put("郭靖", 35);
		map.put("张无忌", 26);
		System.out.println(map.put("杨康", 25));
		System.out.println(map);
		
		System.out.println(map.remove("杨康"));
		System.out.println(map);
		
		System.out.println(map.get("张无忌"));
		System.out.println(map.get("杨康"));
		System.out.println(map);
		
		System.out.println(map.containsKey("杨过"));
		System.out.println(map.containsKey("杨康"));
		System.out.println(map.containsValue(20));
	}
	
	@Test
	public void test1(){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("杨过", 23);
		map.put("郭靖", 35);
		map.put("张无忌", 26);
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Integer value = map.get(key);
			System.out.println(key + ": " + value);
		}
	}
	
	@Test
	public void test2(){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("杨过", 23);
		map.put("郭靖", 35);
		map.put("张无忌", 26);
		map.put(null, null);
		Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		
		for (Map.Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
	}
}
