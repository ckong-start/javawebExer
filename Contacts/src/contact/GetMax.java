package contact;

import java.util.Scanner;

/*
 * 从键盘输入三个数字，从小到大输出。
 */
public class GetMax {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			System.out.println("请输入一个正整数");
			int m = scan.nextInt();
			System.out.println("请输入一个正整数");
			int n = scan.nextInt();
			System.out.println("请输入一个正整数");
			int k = scan.nextInt();
			//方式一
			if(m >= n){
				if(k >= m ){
					System.out.println("min = " + n + ",mid = " + m + ",max = " + k);
				}else if(k <= n){
					System.out.println("min = " + k + ",mid = " + n + ",max = " + m);
				}else {
					System.out.println("min = " + n + ",mid = " + k + ",max = " + m);
				}
			}else {//m <= n
				if(k <= m){
					System.out.println("min = " + k + ",mid = " + m + ",max = " + n);
				}else if(k >= n){
					System.out.println("min = " + m + ",mid = " + n + ",max = " + k);
				}else {
					System.out.println("min = " + m + ",mid = " + k + ",max = " + n);
				}
			}
			
			
			//方式二
//			 int max = m > n ? (m > k ? m : k):(n > k ? n : k);
//			 int mid = m > n ? (m > k ? (k > n ? k : n) : m) : (n > k ? (m > k ? m : k): n);
//			 int min = m > n ? (n > k ? k : n):(m > k ? k : m);
//			 System.out.println("min = " + min + " , mid = " + mid + " , max = " + max);
		
		
			//方式三
//			int[] arr = new int[3];
//			for (int i = 0; i < arr.length; i++) {
//				System.out.println("请输入一个正整数");
//				arr[i] = scan.nextInt();
//			}
//			for (int i = 0; i < arr.length; i++) {
//				for (int j = arr.length -1; j > 0; j--) {
//					if(arr[j - 1] > arr[j]){
//						int temp = arr[j - 1];
//						arr[j -1] = arr[j];
//						arr[j] = temp;
//					}
//				}
//			}
//			System.out.print("min = " + arr[0] + " , mid = " + arr[1] + " , max = " + arr[2]);
	}
}
