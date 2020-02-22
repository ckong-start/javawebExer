package exer;

public class Day02 {
	public static void main(String[] args) {
		Day02.test7();
	}
	
	public static void test1(){
		byte b1 = 10;
		byte b2 = 20;
		byte b3 = (byte) (b1 + b2);
		short s1 = 1000;
		short s2 = 2000;
		short s3 = (short) (s1 + s2);
		char ch1 = 'a';
		int i1 = 30;
		int ch3 = ch1 - i1;
		System.out.println("byte类型b1和b2的和为：\n" + b3);
		System.out.println("short类型s1和s2的和为：\n" + s3);
		System.out.println("char类型ch1和int类型i1的差为：\n" + ch3);
		
	}
	
	public static void test2(){
		int i1 = 100;
		long l1 = 200L;
		long add = i1 + l1;
		long l2 = 1000000L;
		float f2 = 0.44F;
		float add2 = l2 + f2;
		int i3 = 1000000;
		double d3 = 0.45;
		double add3 = i3 + d3;
		float f4 = 1000000.0F;
		double d4 = 1.2625;
		double add4 = f4 + d4;
		System.out.println("add 的值：" + add);
		System.out.println("add2的值：" + add2);
		System.out.println("add3的值：" + add3);
		System.out.println("add4的值：" + add4);
	}
	
	public static void test3(){
		char ch = 'J';
		ch = (char)(ch + 32);
		char ch2 = 'a';
		ch2 += -32;
		double d3 = 3.5;
		int i3 = 100;
		double sum3 = d3 + i3;
		double d4 = 10.0;
		int i4 = 174;
		int mul4 = (int)(d4 * i4);
		System.out.println(ch);
		System.out.println(ch2);
		System.out.println("sum3的值：" + sum3);
		System.out.println("sum3的整数部分的值：" + (int)sum3);
		System.out.println("mul4的整数部分值：" + mul4);
	}
	
	public static void test4(){
		int a1 = 10;
		int a2 = 11;
		System.out.println("10是偶数？" + (a1 % 2 == 0));
		System.out.println("11是偶数？" + (a2 % 2 == 0));
		int a3 = 12;
		int a4 = 13;
		System.out.println("12是奇数？" + (a3 % 2 == 1));
		System.out.println("13是奇数？" + (a4 % 2 == 1));
	}
	
	public static void test5(){
		int a = 20;
		int b = 20;
		boolean bo;
		bo = (++a % 3 ==0) && (a++ % 7 ==0);
		boolean bo2;
		bo2 = (b++ % 3 ==0) && (++b % 7 == 0);
		System.out.println("bo的值：" + bo + "\n" + "a的值：" + a);
		System.out.println("------------------");
		System.out.println("bo2的值：" + bo + "\n" + "b的值：" + b);
	}
	
	public static void test6(){
		int hours = 89;
		int day = 89 / 24;
		int hour = 89 % 24;
		System.out.println("为抵抗洪水，战士连续作战" + hours + "小时："
				 + "\n89是" + day + "天" + hour + "小时");
	}
	
	public static void test7(){
		int week = 5;
		System.out.print("今天是周" + week + ",100天以后是周");
		week += 100;
		System.out.println((week % 7) != 0 ? week % 7 : "日");
	}
	
	public static void test8(){
		int x = 3;
		int y = 4;
		int z = 1;
		int max;
		max = x > y ? x : y;
		max = max > z ? max : z;
		System.out.println(x + "," + y + "," + z + "中的最大值是：" + max);
	}
	
	public static void test9(){
		int year;
		year = 2018;
		boolean b = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
		System.out.println(year + "是闰年" + b);
	}
	
	public static void test10(){
		double hua = 80.0;
		double she;
		System.out.println("华氏度" + hua + "°F转为摄氏度是" + 
				(hua - 32) / 1.8 + "°C");
	}
	
	public static void test11(){
		int i = 1;
		i *= 0.2;
		i++;
		System.out.println("i=" + i);//1
	}
	
	public static void test12(){
		int i = 2;
		i *= i++;
		int j = 2;
		j *= j + 1;
		int k = 2;
		k *= ++k;
		System.out.println("i=" + i);//4
		System.out.println("j=" + j);//6
		System.out.println("k=" + k);//6
	}
	
}
