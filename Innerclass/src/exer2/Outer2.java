package exer2;

public class Outer2 {
	int num1 = 10;
	static int num2 = 20;
	public void method1(){
		class Inner2{
			int num3 = 30;
//			static int num4 = 40;报错
			public void show(){
				System.out.println(num1);
				System.out.println(num2);
				System.out.println(num3);
				method3();
			}
			/*public static void show2(){
				报错
			}*/
		}
		Inner2 inner2 = new Inner2();
		System.out.println(inner2.num3);
		inner2.show();
	}
	public static void method2(){
		class Inner3{
			int num5 = 50;
//			static int num6 = 60;报错
			public void show(){
				
			}
			/*public static void show2(){
				报错
			}*/
		}
	}
	public void method3(){
		
	}
}
