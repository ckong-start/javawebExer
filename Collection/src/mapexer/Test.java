package mapexer;

import java.util.Collection;
import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		
		
		// test(10);
		/*Test10 t = new Test10();
		long test11 = t.test11(20);
		System.out.println(test11);
		test(20);*/
		/*int penNum = 100 / 3;
		int ballNum = 100 / 2;
		int pencilNum;
		for (int i = 0; i < penNum; i++) {
			for (int j = 0; j < ballNum; j++) {
				pencilNum = 100 - i - j;
				if (i * 3 + j * 2 + pencilNum * 0.5 == 100) {
					System.out.println(i + "," + j + "," + pencilNum);
				}
			}
		}*/
		
		/*	System.out.println(f(9));
		test();*/
	}
	public static void test(){
	
		int num = 98765;
		String str = num + "";
		StringBuilder sb = new StringBuilder(str);
		sb = sb.reverse();
		str = new String(sb);
		System.out.println(Integer.parseInt(str));
		/*char[] arr = str.toCharArray();
		for(int i = 0; i <= arr.length / 2; i++){
			char c = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = c;
		}
		str = new String(arr);
		System.out.println(Integer.parseInt(str));*/
		
	}
	public static long f(int n){
		if(n == 1 || n == 2)return 1;
		return f(n - 2) + f(n - 1);
	}
	/*public static void test(int num){
		long sum = 0;
		int temp;
		for(int i = 1; i <= num; i++){
			temp = 1;
			for(int j = 1; j <= i; j++){
				temp *= j;
			}
			sum += temp;
		}
		System.out.println(sum);
	}*/

	public static void test1(int num) {
		double d = 0.0;
		double h = 100.0;
		for(int i = 0; i < num; i++){
			if(i == 0){
			d += h;
			h /= 2.0;
			}else{
			d += h * 2;
			h /= 2.0;
			}
		}
		System.out.println("第" + num + "次落地共经过" + d + "米");
		System.out.println("第" + num + "次反弹" + h + "米");
	}
}
class Test10{
	public long test11(int num){
		if(num == 1)return 1;
		int temp = 1;
		for(int i = 1; i <= num; i++){
			temp *= i;
		}
		return temp + test11(num - 1);
	}
}