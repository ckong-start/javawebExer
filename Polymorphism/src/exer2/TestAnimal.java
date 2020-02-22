package exer2;

import java.util.ArrayList;
import java.util.Iterator;

public class TestAnimal {
	public static void main(String[] args) {
		ArrayList<Animal> all = new ArrayList<Animal>();
		all.add(new Cat("黑猫",2));
		all.add(new Cat("白猫",3));
		all.add(new Dog("大黄",4));
		all.add(new Dog("二狗子",3));
		//遍历方式一：
		Iterator<Animal> iterator = all.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		//遍历方式二：
		for(Object a : all){
			System.out.println(a);
		}
	}
}
abstract class Animal{
	private String name;
	private int age;
	public Animal() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public abstract String toString();
	public abstract void eat();
}
class Cat extends Animal{
	public Cat(){
		
	}
	public Cat(String name, int age){
		super(name,age);
	}
	@Override
	public void eat() {
		System.out.println("吃鱼");
	}
	@Override
	public String toString() {
		return "Cat [name = " + getName() + ", age = " + getAge() + "]";
	}
	
	
}
class Dog extends Animal{
	public Dog(){
		
	}
	public Dog(String name, int age){
		super(name,age);
	}
	@Override
	public void eat() {
		System.out.println("吃骨头");
	}
	@Override
	public String toString() {
		return "Dog [name = " + getName() + ", age = " + getAge() + "]";
	}
	
}