package exer1;

import org.junit.Test;

public class IntegerTest2 {
	@Test
	public void test(){
		Double num1 = 3.14;
		Double num2 = 3.14;
		System.out.println(num1 == num2);//false
		
		double num3 = 3.14;
		double num4 = 3.14;
		System.out.println(num3 == num4);//true
	}
}
