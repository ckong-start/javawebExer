package exer1;

import java.util.ArrayList;
import java.util.Scanner;

//键盘录入一个字符串，统计字符串中大小写字母及数字字符个数
public class StringTest2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String str = scan.next();
		util2(str);
		scan.close();
	}
	public static void util1(String str){
		int bigCount = 0;
		int smallCount = 0;
		int numCount = 0;
		int otherCount = 0;
		for(int i = 0;i < str.length();i++){
			char ch = str.charAt(i);
			if(ch >= 'A' && ch <= 'Z')bigCount++;
			else if(ch >= 'a' && ch <= 'z')smallCount++;
			else if(ch >= '0' && ch <= '9')numCount++;
			else otherCount++;
		}
		System.out.println("bigCount = " + bigCount);
		System.out.println("smallCount = " + smallCount);
		System.out.println("numCount = " + numCount);
		System.out.println("otherCount = " + otherCount);
	}
	public static void util2(String str){
		int bigCount = 0;
		int smallCount = 0;
		int numCount = 0;
		int otherCount = 0;
		char[] charArr = str.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			char ch = charArr[i];
			if(ch >= 'A' && ch <= 'Z')bigCount++;
			else if(ch >= 'a' && ch <= 'z')smallCount++;
			else if(ch >= '0' && ch <= '9')numCount++;
			else otherCount++;
		}
		System.out.println("bigCount = " + bigCount);
		System.out.println("smallCount = " + smallCount);
		System.out.println("numCount = " + numCount);
		System.out.println("otherCount = " + otherCount);
	}
	
}
