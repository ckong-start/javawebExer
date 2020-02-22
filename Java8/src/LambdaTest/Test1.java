package LambdaTest;

public class Test1 {
	public static void main(String[] args) {
		method(10,(int num) -> {
			for(int i = 0; i < 10 ; i ++){
				System.out.println("HelloWorld");
			}
		}); 
	}
	
	public static void method(int num, A a){
		a.demo1(num);
	}
}
@FunctionalInterface
interface A{
	void demo1(int num);
}