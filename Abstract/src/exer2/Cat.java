package exer2;

public class Cat extends Animal {
	public int num = 20;
	public Cat(){
		
	}
	
	public Cat(String name,int age,String color) {
		super(name,age,color);
	}
	public void catchMouse(){
		System.out.println(getColor() + "的" + getName() + "吃" +"在抓老鼠");
	}
	
	public void eat(){
		System.out.println("猫吃鱼");
	}

	@Override
	public void eat(String something) {
		System.out.println(getColor() + "的" + getName() + "吃" + something);
	}

}
