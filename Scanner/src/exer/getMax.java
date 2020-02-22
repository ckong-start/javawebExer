package exer;

import java.util.Scanner;

public class getMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入第一个整数：");
		int num1 = sc.nextInt();
		System.out.print("请输入第二个整数：");
		int num2 = sc.nextInt();
		System.out.print("请输入第三个整数：");
		int num3 = sc.nextInt();
		int max,min,sum;
//		max = num1 > num2 ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);
//		min = num1 > num2 ? ((num2 > num3) ? num3 : num2) : ((num1 > num3) ? num3 : num1);
		int temp = num1 > num2 ? num1 : num2;
		max = temp > num3 ? temp : num3;
		temp = num1 > num2 ? num2 : num1;
		min = temp > num3 ? num3 : temp;
		sum = num1 + num2 + num3;
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		System.out.println("sum = " + sum);
		sc.close();
	}
}
