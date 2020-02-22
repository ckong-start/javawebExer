package exer;

import java.util.HashMap;

public class MethodTest1 {
	static HashMap<Integer,Long> map = new HashMap<>();
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		long i = Method(6);
		long end = System.nanoTime();
		System.out.println(i);
		System.out.println(end - start);
		
	}
	//利用递归实现斐波那契数列
	public static long Method(int num){
		if(num == 1 || num == 2){
			return 1;
		}
		return Method(num - 1) + Method(num - 2);
	}
	//备忘录算法
	public static long Method1(int num){
		if(num == 1 || num == 2){
			return 1;
		}
		Long value;
		if((value = map.get(num)) == null){
			value = Method1(num - 1) + Method1(num - 2);
			map.put(num, value);
		}
		return value;
	}
	
	
	//用普通循环实现斐波那契数列
	public static long Method2(int num){
		
		long l = 1, j = 1, k = 1;
		for (int i = 3; i <= num; i++) {
			k = l + j;
			l = j;
			j = k;
		}
		return num == 0 ? 0 : k;
	}
}
