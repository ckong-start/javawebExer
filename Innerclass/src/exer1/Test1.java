package exer1;

public class Test1 {
	public static void main(String[] args) {
		Outer.Inner in = new Sub();
		in.method();
	}
}
class Outer{
	abstract class Inner{
		abstract void method();
	}
}
class Sub extends Outer.Inner{
	static Outer out = new Outer();
	Sub(){
		out.super();
	}
	public void method(){
		System.out.println("hello inner");
	}
}