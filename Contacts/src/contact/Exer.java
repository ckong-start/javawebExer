package contact;

import java.util.Random;
import java.util.Scanner;

public class Exer {
	public static void main(String[] args) {
		Exer e = new Exer();

		// 输出1000以内偶数的和
		// e.GetSum();

		// 输出指定的长和宽的长方形
		// System.out.println("请输入长：");
		// int m = input.nextInt();
		// System.out.println("请输入宽：");
		// int n = input.nextInt();
		// e.GetRectangle(m, n);

		// 输出指定高度的正三角形
		// System.out.println("请输入高度：");
		// int m = input.nextInt();
		// e.GetTriangle(m);

		// 输出指定高度的倒三角形
		// System.out.println("请输入高度：");
		// int m = input.nextInt();
		// e.GetTriangle1(m);

		e.GuessNumber();
	}

	// 求调和级数中从第多少项开始值大于10
	public void GetNumber() {
		double sum = 0.0;
		int i;
		for (i = 1;; i++) {
			sum += (1.0 / i);
			if (sum >= 10)
				break;
		}
		System.out.println("从第" + i + "项开始，调和级数大于10");
	}

	// 猜数字
	public void GuessNumber() {
		int num = new Random().nextInt(100);
		int guessNum;
		int count = 0;
		int start = 1;
		int end = 100;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("请输入一个" + start + "~~" + end + "的数字：");
			guessNum = sc.nextInt();
			if (guessNum > num) {
				if(guessNum < end)
				end = guessNum - 1;
				System.out.println("猜大了。");
			} else if (guessNum < num) {
				if(guessNum > start)
				start = guessNum + 1;
				System.out.println("猜小了。");
			} else
				System.out.println("猜对了!");
			count++;
		} while (guessNum != num);
		System.out.println("一共猜了:" + count + "次");
		sc.close();
	}
	//求1-1000的总和
	public void GetSum() {
		int sum = 0;
		for (int i = 0; i <= 1000; i += 2) {
			sum += i;
			System.out.println(i);
		}
		System.out.println("sum = " + sum);
		
	}
	// 输出指定的长和宽的长方形
	public void GetRectangle(int m, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
	// 输出指定高度的正三角形
	public void GetTriangle(int m) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	// 输出指定高度的倒三角形
	public void GetTriangle1(int m) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
