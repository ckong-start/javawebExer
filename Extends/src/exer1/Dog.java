package exer1;

public class Dog extends Animal {
	
	public void lookHome(){
		System.out.println("狗看家");
	}
	public void eat(){
		System.out.println("狗吃骨头");
	}
	public Dog(String name,int age) {
		super(name,age);
	}
	public Dog(){
		
	}
}
