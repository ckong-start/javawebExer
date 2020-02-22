package exer;

public class Test {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		String s3 = new String("hello");
		String s4 = new String("world");
		method1(s1, s2);
		System.out.println(s1);
		System.out.println(s2);
		method1(s3, s4);
		System.out.println(s3);
		System.out.println(s4);
	}
	public static void method1(String str1, String str2){
		str1 += "world";
		str2 += "!";
		System.out.println(str1);
		System.out.println(str2);
	}
}
