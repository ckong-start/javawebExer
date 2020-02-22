package exer1;

public class Student {
	private String name;
	private int age;
	private int num;
	static private int id = 1910100001;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Student() {
		this.num = id++;
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		this.num = id++;
	}
	
	
}
