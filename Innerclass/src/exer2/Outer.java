package exer2;

public class Outer {
	int num1 = 10;
	static int num2 = 20;
	
	
	public void show1(){
		System.out.println("外部类的实例方法");
	}
	public static void show2(){
		System.out.println("外部类的静态方法");
	}
	public void test(){
		Inner inner = new Inner();
		System.out.println(inner.num3);
	}
	class Inner{
		int num3 = 30;
//		static int num4 = 40;定义静态属性报错
		public void show(){
			System.out.println(Outer.this.num1);
			System.out.println(Outer.this.num2);
			Outer.this.show1();
			Outer.this.show2();
		}
		//定义静态方法报错
		/*public static void show1(){
			
		}*/
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.show1();
		outer.show2();
		outer.test();
		Inner inner = outer.new Inner();
		System.out.println(inner.num3);
		
	}
}
