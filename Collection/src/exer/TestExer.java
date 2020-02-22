package exer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestExer {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("info.properties");
		pro.load(fis);
		String value = pro.getProperty("user");
		System.out.println(value);
		/*int i = 98765;
		StringBuilder sb = new StringBuilder().append(i).reverse();
		System.out.println(Integer.parseInt(new String(sb)));
		 */
		/*int num = print(201903,201906,201901,201909);
		System.out.println(num);*/
	}
	public static int print(int num1, int num2, int num3, int num4){
		int n1 = num1 % 100;
		int n2 = num2 % 100;
		int n3 = num3 % 100;
		int n4 = num4 % 100;
		int len1 = n2 - n1 + 1;
		int len2 = n4 - n3 + 1;
		int[] arr1 = new int[len1];
		int[] arr2 = new int[len2];
		int count = 0;
		method(arr1,n1);
		method(arr2,n3);
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]){
					count++;
					break;
				}
			}
		}
		return count;
	}
	private static void method(int[] arr, int n1){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = n1++;
		}	
	}
}
