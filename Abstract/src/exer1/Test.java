package exer1;
/*
 * 定义一个抽象类Person，有name,age,sex三个属性，创建构造函数，给这三个属性赋值，重写打印描述信息方法，打印三个属性值；
 * 这个类中有两个抽象方法work和hello；定义两个子类Teacher，Student；
 * 教师的work实现是：教书育人，hello实现是：“同学好”；学生的work实现是：认真学习，hello实现是“老师好”。
 */

abstract class Person{
	String name;
	int age;
	String sex;
	public Person(){
		
	}
	public Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String toString(){
		return "姓名：" + name + " 年龄：" + age + " 性别：" + sex;
	}
	public abstract void work();
	abstract void hello();
}
class Teacher extends Person{
	public Teacher(String name, int age, String sex){
		super(name,age,sex);
	}
	@Override
	public void work() {
		System.out.println("教书育人");
	}
	@Override
	public void hello() {
		System.out.println("同学好");
	}
}
class Student extends Person{
	public Student(){
		
	}
	public Student(String name, int age, String sex){
		super(name,age,sex);
	}
	@Override
	public void work() {
		System.out.println("认真学习");
	}

	@Override
	public void hello() {
		System.out.println("老师好");
	}
}
public class Test{
	public static void main(String[] args) {
		Person p1 = new Student("Tom", 20, "男");
		Person p2 = new Teacher("Jack", 40, "男");
		p1.hello();
		p1.work();
		p2.hello();
		p2.work();
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}
}
