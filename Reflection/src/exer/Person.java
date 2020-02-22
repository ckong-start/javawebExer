package exer;

public class Person {
	private String name;
	private int age;
	private char gender;
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	private Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	private Person(int age){
		this.age = age;
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
	
	public static void show(){
		System.out.println("我是一个人");
	}
	
	private String showNation(String nation){
		System.out.println(toString() + ",nation=" + nation);
		return nation;
	}
	@Override
	public String toString() {
		return "Person: name=" + name + ", age=" + age + "";
	}
	
	
}
