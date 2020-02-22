package exer1;

public class IntegerTest1 {
	public static final Integer num1 = 100;
	public static final Integer num2 = 100;
	public static final Integer num3;
	public static final Integer num4;
	public static final Integer num5 = 50;
	public static final Integer num6 = 50;
	public static final Integer num7;
	public static final Integer num8;
	public static final Integer num9;
	
	static {
		num3 = 100;
		num4 = 100;
		num7 = num5 + num6;
		num8 = 50;
		num9 = 50;
	}
	
	public static void main(String[] args) {	
		System.out.println(num1 == num2);//true
		System.out.println(num3 == num4);//true
		System.out.println(num1 == num5 + num6);//true
		System.out.println(num1 == num7);//true	
		System.out.println(num1 == (num8 + num9));//true
	}
}
