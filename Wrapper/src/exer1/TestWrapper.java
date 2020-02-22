package exer1;

import org.junit.Test;

public class TestWrapper {
	@Test
	public void test4(){
		String str = 4 + "";
		System.out.println("str = " + str);
		char num1 = 'a';
		Character c1 = new Character(num1);
		System.out.println("c1 = " + c1);
		Character c2 = c1.valueOf('b');
		System.out.println("c2 = " + c2);
		char num2 = c2.charValue();
		System.out.println("num2 = " + num2);
	}
	
	@Test
	public void test3(){
		double num1 = 2.0;
		Double d1 = new Double(num1);
		System.out.println("d1 = " + d1);
		Double d2 = d1.valueOf(3.0);
		System.out.println("d2 = " + d2);
		double num2 = d2.doubleValue();
		System.out.println("num2 = " + num2);
	}
	
	@Test
	public void test2(){
		int num1 = 2;
		Integer i1 = new Integer(num1);
		System.out.println("i1 = " + i1);
		Integer i2 = i1.valueOf(3);
		System.out.println("i2 = " + i2);
		int num2 = i2.intValue();
		System.out.println("num2 = " + num2);
	}
	
	@Test
	public void test1(){
		int num1 = 3;
		String s1 = num1 + "";
		String s2 = String.valueOf(num1);
		String s3 = Integer.toString(num1);
		int num2 = Integer.parseInt(s1);
		
	}
}
