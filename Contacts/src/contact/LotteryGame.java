package contact;

import java.util.Scanner;

public class LotteryGame {
	public static void main(String[] args) {
		int lotteryNum = (int)(Math.random() * 90 + 10);	//随机生成彩票随机数
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个数字：(0-99)");  //获取用户彩票号码
		int userNum = scan.nextInt(); 
		System.out.println("彩票号码为：" + lotteryNum);
		int a1 = lotteryNum / 10;     //取随机彩票的十位和个位数字
		int a2 = lotteryNum % 10;
		int b1 = userNum / 10;      //取用户彩票的十位和个位数字
		int b2 = userNum % 10;
		if (b1 < 10){		
			if (userNum != lotteryNum){
				if (b1 == a2 && b2 == a1){
					System.out.println("恭喜获得奖金3000美元");
				}else if (b1 == a2 || b2 == a1){
					System.out.println("恭喜获得奖金500美元");
				}else if (b1 == a1 || b2 == a2){
					System.out.println("恭喜获得奖金1000美元");
				}else {
					System.out.println("彩票作废");
				}
			}else
				System.out.println("恭喜获得奖金10000美元");
			}else{
				System.out.println("你输入的彩票号码有误");
		}
	}
}


