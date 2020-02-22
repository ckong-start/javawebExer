package exer;

public class Day01 {
	public static void main(String[] args) {
		Day01.test1();
		Day01.test2();
		Day01.test3();
		Day01.test4();
		Day01.test5();
		Day01.test6();
		Day01.test7();
		Day01.test8();
		Day01.test9();
		Day01.test10();
	}
	
	public static void test1(){
		System.out.println("善学如春起之苗");
		System.out.println("不见其增，日有所长");
		System.out.println("假学如磨刀之石");
		System.out.println("加油吧！少年");
		System.out.println('J');
		System.out.println('A');
		System.out.println('V');
		System.out.println('A');
		System.out.println('!');
		System.out.println("***********");
	}
	
	public static void test2(){
		System.out.println("-2147483648");
		System.out.println("-100");
		System.out.println("0");
		System.out.println("100");
		System.out.println("2147483647");
		System.out.println("-100.0");
		System.out.println("-10.0");
		System.out.println("0.0");
		System.out.println("10.9");
		System.out.println("100.9");
		System.out.println("***********");
	}
	
	public static void test3(){
		System.out.println("true");
		System.out.println("false");
		System.out.println("***********");
	}
	
	public static void test4(){
		byte b1 = -128;
		byte b2 = 127;
		short s1 = -32768;
		short s2 = 32767;
		int i1 = -2147483648;
		int i2 = 2147483647;
		long l1 = -2147483649L;
		long l2 = 2147483648L;
		System.out.println(b1 + "\n" + b2 + "\n" + s1 + "\n" + 
		s2 + "\n" + i1 + "\n" + i2 + "\n" + l1 + "\n" + l2 );
		System.out.println("***********");
	}
	
	public static void test5(){
		float f1 = -3.14F;
		float f2 = 3.14F;
		double d1 = -3.4;
		double d2 = 3.4;
		System.out.println(f1 + "\n" + f2 + "\n" + d1 + "\n" + d2);
		System.out.println("***********");
	}
	
	public static void test6(){
		char c1 = '9';
		char c2 = 'J';
		char c3 = 'a';
		char c4 = ' ';
		char c5 = '@';
		boolean bo1 = true;
		boolean bo2 = false;
		System.out.println(c1 + "\n" + c2 + "\n" + c3 + "\n" + 
		c4 + "\n" + c5 + "\n" + bo1 + "\n" + bo2);
		System.out.println("***********");
	}
	
	public static void test7(){
		int i3 = 10;
		int i4 = 20;
		System.out.println("交换前：i3 = " + i3 + ",i4 = " + i4);
		int temp;
		temp = i3;
		i3 = i4;
		i4 = temp;
		System.out.println("交换后：i3 = " + i3 + ",i4 = " + i4);
		System.out.println("***********");
	}
	
	public static void test8(){
		int x = 100;
		int y = 200;
		int add;
		add = x + y;
		int sub;
		sub = x - y;
		int mul;
		mul = x * y;
		int div;
		div = x / y;
		System.out.println("x,y的和为:" + add);
		System.out.println("x,y的差为:" + sub);
		System.out.println("x,y的积为:" + mul);
		System.out.println("x,y的商为:" + div);
		System.out.println("***********");
	}
	
	public static void test9(){
		double x1 = 100.8;
		double y1 = 20.6;
		double add1;
		add1 = x1 + y1;
		double sub1;
		sub1 = x1 - y1;
		double mul1;
		mul1 = x1 * y1;
		double div1;
		div1 = x1 / y1;
		System.out.println("x1,y1的和为:" + add1);
		System.out.println("x1,y1的差为:" + sub1);
		System.out.println("x1,y1的积为:" + mul1);
		System.out.println("x1,y1的商为:" + div1);
		System.out.println("***********");
	}
	
	public static void test10(){
		byte num1 = 10;
		short num2 = 100;
		int num3 = 1000;
		long num4 = 10000L;
		float num5 = 100000.0F;
		double num6 = 1000000.0;
		char num7 = 'Z';
		boolean num8 = false;
		System.out.print("整数类型-byte：");
		System.out.println(num1);
		System.out.print("整数类型-short：");
		System.out.println(num2);
		System.out.print("整数类型-int：");
		System.out.println(num3);
		System.out.print("整数类型-long：");
		System.out.println(num4);
		System.out.print("小数类型-float：");
		System.out.println(num5);
		System.out.print("小数类型-double：");
		System.out.println(num6);
		System.out.print("字符类型-char：");
		System.out.println(num7);
		System.out.print("布尔类型-boolean：");
		System.out.println(num8);
		System.out.println("***********");
	}
}
/*
 * 1.基本数据类型有byte、short、int、long；String不属于基本数据类型，为引用数据类型
 * 2.不正确，少了F；14
 * 3.可以
 */
