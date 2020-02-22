package exer;

import java.util.Date;

public class StringTest {
	public static void main(String[] args) {
		Date date = new Date();
		String s = date.toString();
		System.out.println(s);
		String a = "123";
		String b = "123";
		String c = new String("123");
		String d = new String("123");
		System.out.println(a.equals(b));// t
		System.out.println(a == b);// t
		System.out.println(c.equals(d));// t
		System.out.println(c == d);// f
		System.out.println(a.equals(c));// t
		System.out.println(a == c);// f
	}
}