package contact;

import java.util.Scanner;

public class Exer1 {
	public static void main(String[] args) {
		// new Exer1().printRhombus();
		// new Exer1().printPrimeNumber();
		new Exer1().getNumber();

	}
	
	//692223361219-->6922233612192
	//Ean-13码规则：第十三位数字是前十二位数字经过计算得到的校验码。
	public void getNumber(){
		int[] arr = new int[12];
		int sum1,sum2,sum,num;
		sum1 = sum2 = sum = num = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print("请输入一个数字(0`9)：");
			arr[i] = new Scanner(System.in).nextInt();
			if((i + 1) % 2 == 1)sum1 += arr[i];
			if((i + 1) % 2 == 0)sum2 += arr[i];
		}
		sum = sum1 + sum2 * 3;
		num = (10 - (sum % 10)) % 10;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println(num);
	}
	
	// 打印空心的菱形
	public void printRhombus() {
		// 上半部分
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (10 - i * 2); j++) {
				if (j == 5 - i) {
					for (int k = 0; k < (i * 2); k++) {
						System.out.print(" ");
					}
				}
				System.out.print("*");
			}
			System.out.println();
		}
		// 下半部分
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j < (10 - i * 2); j++) {
				if (j == 5 - i) {
					for (int k = 0; k < (i * 2); k++) {
						System.out.print(" ");
					}
				}
				System.out.print("*");
			}
			System.out.println();
		}

	}

	// 编写程序，打印100-200之间的质数
	public void printPrimeNumber() {
		int m = 0;
		label: for (int i = 100; i <= 200; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					continue label;
			}
			System.out.print(i + " ");
			m++;
			if (m >= 5) {
				m = 0;
				System.out.println();
			}
		}

	}
}
