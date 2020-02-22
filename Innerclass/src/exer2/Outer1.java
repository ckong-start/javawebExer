package exer2;

public class Outer1 {
	int num1 = 10;
	static int num2 = 20;
	int num3 = 30;
	static int num4 = 40;
	public void show(){}
	public static void show1(){}
	
	
	public static class Inner1{
		int num3 = 30;
		static int num4 = 40;
		
		public void show(){
//			System.out.println(num1);报错，不能调用非静态
//			Outer1.show();道理同上
			System.out.println(num2);
			System.out.println(num3);
			System.out.println(num4);
			System.out.println();
			Outer1.show1();
			show1();
		}
		public static void show1(){
			
		}
	}
}
