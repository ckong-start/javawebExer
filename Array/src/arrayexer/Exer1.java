package arrayexer;

import java.util.Arrays;
import java.util.Scanner;

public class Exer1 {
	public static void main(String[] args) {
		System.out.println("请输入一个数：");
		int num = new Scanner(System.in).nextInt();
		new Exer1().method6(num);
	}

	// 将26个大写字母存进数组中，然后打印出来
	public void method() {
		char[] arr = new char[26];
		for (int i = 0; i < arr.length; i++) {
			char c = (char) ('A' + i);
			arr[i] = c;
			System.out.println(arr[i]);
		}
	}

	// 创建一个char类型的36个元素的数组，前26个元素放置'A'-'Z',
	// 后10个元素放置'0'-'9'。
	public void method1() {
		char[] arr = new char[36];
		for (int i = 0; i < arr.length; i++) {
			if (i < 26) {
				arr[i] = (char) ('A' + i);
			} else {
				arr[i] = (char) ('0' + i - 26);
			}
			System.out.println(arr[i]);
		}
		//逆序输出
//		for (int i = arr.length -1; i >= 0; i--) {
//			System.out.println(arr[i]);
//		}
	}
	
	//求斐波那契数列前20项
	public void method2(){
		int[] arr = new int[20];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//向一个有序的数组中插入一个数
	public void method3(int num){
		int[] arr = new int[]{10,20,30,40,50,60,70,80,90};
		int[] arr1 = new int[arr.length + 1];
		boolean isFlag = true;
		for (int i = 0; i < arr.length; i++) {
			if(num < arr[i]){
				isFlag = false;
				arr1[i] = num;
				for(;i < arr.length;i++){
					arr1[i + 1] = arr[i];
				}
			}else {
				arr1[i] = arr[i];
			}
		}
		if(isFlag)
			arr1[arr.length] = num;
		System.out.println(Arrays.toString(arr1));
		
	}
	
	//定义一个4行4列的二维数组然后将第1行和第4行的数据进行交换，
	//将第2行和第3行的数据进行交换
	public void method4(){
		int[][] arr = new int[4][4];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random() * 9 + 1);
			}
		}
		System.out.println("交换前的数组");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[arr.length - 1 - i][j];
				arr[arr.length - 1 - i][j] = temp;
			}
		}
		System.out.println("交换后的数组");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//定义一个3行4列的二维数组，编写程序将四周的数据清0
	public void method5(){
		int[][] arr = new int[3][4];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random() * 9 + 1);
			}
		}
		System.out.println("清0前的数组");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i == 1 && (j == 1 || j == 2))continue;
				arr[i][j] = 0;
			}
		}
		System.out.println("清0后的数组");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	//定义一个N*N二维数组，找出每行中最大值组成一个一维数组并输出
	public void method6(int n){
		int[][] arr = new int[n][n];
		int[] arrMax = new int[n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random() * 20 + 1);
			}
			for (int j = 0; j < arr[i].length; j++) {
				if(arrMax[i] <= arr[i][j])arrMax[i] = arr[i][j];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
				String space = (arr[i][j] + "").length() == 1 ? "0" : "";
				System.out.print(space + arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(arrMax));
	}
}