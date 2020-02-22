package exer1;

public class Animal {
	public String name;
	public int age;
	public int num = 10;
	
	void eat(){
		System.out.println("吃东西");
	}
	public Animal(){
		
	}
	public Animal(String name , int age){
		this.name = name;
		this.age = age;
	}
}
