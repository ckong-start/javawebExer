package exer;

public class Day03 {
	public static void main(String[] args) {
		int num = 4;
		Day03.test9();
	}
	
	public static void test1(){
		int x = 1,y = 1;
		if(x++ == 1 || ++y == 2){
			x = 7;
		}
		System.out.println("x = " + x + ", y = " + y);
	}
	
	public static void test2(){
		boolean b = true;
		if(b = false){
			System.out.println('a');
		}else if(b){
			System.out.println('b');
		}else if(!b){
			System.out.println('c');
		}else {
			System.out.println('d');
		}
	}
	
	public static void test3(){
		int x = 2,y = 3;
		switch (x){
			default:
				y++;
			case 3:
				y++;
				break;
			case 4:
				y++;
		}
		System.out.println("y = " + y);
	}
	
	public static void test4(){
		byte x = 127;
		byte y = (byte)(x >> 9);
		System.out.println(y);
	}
	
	//考试成绩分等级，请根据指定的成绩，输出对应的等级
	public static void test5(int num){
		switch (num / 10){
		case 10:
		case 9:
			System.out.println("A等");
			break;
		case 8:
			System.out.println("B等");
			break;
		case 7:
			System.out.println("C等");
			break;
		case 6:
			System.out.println("D等");
			break;
		default:
			System.out.println("E等");
		}
	}
	
	//请根据指定的月份，打印出对应月份的天数。
	public static void test6(int num){
		switch(num){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(num + "月份有" + 31 + "天");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(num + "月份有" + 30 + "天");
			break;
		case 2:
			System.out.println(num + "月份有" + 28 + "天");
			break;
		default:
			System.out.println("你输入的月份有误！");
		}
	}
	
	public static void test7(){
		int a = 7;
		int b = 10;
		System.out.println("交换之前a = " + a + ",b = " + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("交换之后a = " + a + ",b = " + b);
		/*使用位运算符
		 * a = a ^ b;
		 * b = a ^ b;
		 * a = a ^ b;
		 */
	}
	
	public static void test8(){
		//用三元判断两个数是否相等
		int a = 1;
		int b = 2;
		boolean bo = (a == b) ? true : false;
		System.out.println(bo);
		//获取两个数中最大值
		int max1 = (a > b) ? a : b;
		//获取三个数中最大值
		int c = 3;
		int max2 = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
	}
	
	//1.打印1 到100 之内的整数，但数字中包含9 的要跳过
	//2.每行输出5 个满足条件的数，之间用空格分隔
	//3.如：1 2 3 4 5
	public static void test9(){
		int count = 0;
		for (int i = 1;i <= 100;i++){
			if(i % 10 == 9)continue;
			if(i / 10 % 10 == 9)continue;
			String str = (i + "").length() == 1 ? "0" : "";
			System.out.print(str + i + " ");
			count++;
			if(count == 5){
				System.out.println();
				count = 0;
			}
		}
	}
	
	//1.定义一个方法,按照从大到小的顺序输出四位数中的个位+百位=十位+千位 的数字及个数
	//2.每行输出5 个满足条件的数，之间用空格分隔
	//3.如：9999 9988 9977 9966 9955
	public static void test10(){
		int count = 0;
		for(int i = 9999;i > 1000;i--){
			int ge = i % 10;
			int shi = i / 10 % 10;
			int bai = i / 100 % 10;
			int qian = i / 1000 % 10;
			if((ge + bai) == (shi + qian)){
				System.out.print(i + " ");
				count++;
			}
			if(count == 5){
				System.out.println();
				count = 0;
			}
		}
	}
	
	public static void test11(){
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 5;j++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
