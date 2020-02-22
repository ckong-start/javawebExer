package exer1;

public class Test1 {
	public static void main(String[] args) {
		AnimalTest a1 = new Cat();
		a1.shout();
		new Dog().shout();
		AnimalTest a2 = new AnimalTest(){
			@Override
			public void shout() {
				System.out.println("鸡会咯咯叫");
			}
		};
		a2.shout();
		new AnimalTest(){
			@Override
			public void shout() {
				System.out.println("羊会咩咩叫");
			}
		}.shout();
	}
}
abstract class AnimalTest{
	public abstract void shout();
}
class Cat extends AnimalTest{

	@Override
	public void shout() {
		System.out.println("猫会喵喵叫");
	}
	
}
class Dog extends AnimalTest{

	@Override
	public void shout() {
		System.out.println("狗会汪汪叫");
	}
	
}