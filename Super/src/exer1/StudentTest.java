package exer1;

public class StudentTest {
	public static void main(String[] args) {
		Person p = new Person("jack", 20);
		Student s = new Student("jack", 20, 10001, 90);
		System.out.println(p.say());
		System.out.println(s.say());
	}
}
class Person{
	private String name;
	private int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
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
	public String say(){
		return "姓名：" + name + " ，年龄：" + age;
	}
}
class Student extends Person{
	private int id;
	private int score;
	public Student() {
		super();
	}
	public Student(String name,int age,int id, int score) {
		super(name, age);
		this.id = id;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String say(){
		return super.say() + " ，id:" + id + " ， score:" + score;
	}
}