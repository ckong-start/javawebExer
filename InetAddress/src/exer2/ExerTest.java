package exer2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ExerTest {

	@Test
	public void test(){
		String content = "中中国55kfff";
		char[] c = content.toCharArray();
		Map<Character,Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < c.length; i++){
			char ch = c[i];
			if(map.get(ch) == null){
				map.put(ch, 1);
			}else{
				map.put(ch,map.get(ch) + 1);
			}
		}
		Set<Character> set = map.keySet();
		for(Character ch : set){
			System.out.println(ch + ":" + map.get(ch));
		}
	}
	public static long test(int num){
		
			if(num == 1 || num == 2)return 1;
			return test(num - 1) + test(num -2);
		
	}
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(test(i));
		}
	}
	@Test
	public void test2(){
		char[] ch = {'a','b','c','d','e','f','g','h'};
		int start = 0;
		int end = ch.length - 1;
		int mid = (start + end) / 2;
		while(start <= end){
			if(ch[mid] == 'g')break;
			if(ch[mid] > 'g'){
				end = mid - 1;
				mid = (start + end) / 2;
			}else{
				start = mid + 1;
				mid = (start + end) / 2;
			}
		}
		if(start > end)System.out.println("not find");
		else System.out.println(mid);
	}
	@Test
	public void test3(){
		List<Integer> list = Arrays.asList(1,2,3,3,4,4,5,5,6,1,9,3,25,4);
		Set<Integer> set = new HashSet<>(list);
		set.stream().forEach(System.out::println);
	}
}
