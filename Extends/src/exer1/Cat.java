package exer1;

public class Cat extends Animal {
	public int num = 20;
	
	public Cat(String name,int age) {
		super(name,age);
	}
	public void catchMouse(){
		System.out.println("猫抓老鼠");
	}
	
	public void eat(){
		System.out.println("猫吃鱼");
	}
	public void method(){
		int num = 30;
		System.out.println("num = " + num);
		System.out.println("this.num = " + this.num);
		System.out.println("super.num = " + super.num);
	}
}
