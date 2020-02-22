package exer;

import org.junit.Test;

public class TestRef {

	@Test
	public void test() throws ClassNotFoundException {
		
		Class clazz1 = Person.class;
		System.out.println(clazz1);
		Person p = new Person();
		Class clazz2 = p.getClass();
		System.out.println(clazz2);
		Class clazz3 = Class.forName("exer.Person");
		System.out.println(clazz3);
		ClassLoader scl = ClassLoader.getSystemClassLoader();
		Class clazz4 = scl.loadClass("exer.Person");
		System.out.println(clazz4);
	}
}
