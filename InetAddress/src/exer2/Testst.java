package exer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.junit.Test;

public class Testst{
	public static void main(String[] args) {
		String replace = replace("aabbccdd","bb","dd");
		System.out.println(replace);
	}
	public static String replace(String text, String targer, String replace){
		String[] strArr = text.split(targer);
		String str = "";
		for(int i = 0; i < strArr.length; i++){
			if(i == strArr.length - 1)str += strArr[i];
			else str += strArr[i] + replace;
		}
		return str;
	}
	@Test
	public void test1(){
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 100 + 1);
		}
		System.out.println(Arrays.toString(arr));
		long start = System.nanoTime();
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			index = i;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[index] > arr[j])index = j;
			}
			if(index != i){
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		long end = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println(end - start);
	}
	@Test
	public void test() {
		String data = "aabcexmkduyruieiopxzkkkkasdfjxjdsds";
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : data.toCharArray()) {
			if(map.get(ch) == null)map.put(ch, 1);
			else map.put(ch, map.get(ch) + 1);
		}
		Integer max = Collections.max(map.values());
		for (char ch : map.keySet()) {
			if(map.get(ch).equals(max))
				System.out.println(ch + "：" + max);
		}
		
	}
	
}
