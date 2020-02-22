package exer;

import org.junit.Test;

public class test1 {
	@Test
	public void test(){
		MyGeneric<String> m = new MyGeneric<String>();
		m.method1("one");
		m.method3(123);
	}
}
class MyGeneric<E>{
	private E e;
	
	public void method1(E e){
		System.out.println("这是方法一");
		method2(e);
	}
	
	public E method2(E e){
		System.out.println("这是方法二");
		return e;
	}
	
	public <T> void method3(T t){
		System.out.println("这是方法三");
	}
}