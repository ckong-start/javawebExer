package exer2;

public class Dog extends Animal {
	
	public Dog(){
		
	}
	public Dog(String name,int age,String color) {
		super(name,age,color);
	}
	public void lookHome(){
		System.out.println(getColor() + "的" + getName() + "在看家");
	}
	@Override
	public void eat(String something) {
		System.out.println(getColor() + "的" + getName() + "吃" + something);
		
	}
}
