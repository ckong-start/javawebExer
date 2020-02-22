package contact;

import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 产生3个1~6的随机数
		int a = (int) (Math.random() * 6 + 1);
		int b = (int) (Math.random() * 6 + 1);
		int c = (int) (Math.random() * 6 + 1);
		// 将随机数的结果存在result中
		String result;
		if (a == b && a == c)
			result = "豹子";
		else if (a + b + c <= 9)
			result = "小";
		else
			result = "大";
		// 用户输入的结果猜想
		System.out.println("买定离手，请押宝：(选择：大，小，豹子)");
		String guess = input.next();
		// 判断结果
		if (result.equals(guess)){
			System.out.println("猜对了" + "\n" + "a = " + a + ", b = " + b + ", c = " + c);
			System.out.println("a + b + c =" + (a + b + c));
		}else {
			System.out.println("猜错了" + "\n" + "a = " + a + ", b = " + b + ", c = " + c);
			System.out.println("a + b + c = " + (a + b + c));
		}
	}
}


