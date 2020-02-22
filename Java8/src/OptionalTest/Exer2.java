package OptionalTest;

import java.util.ArrayList;

/*
 * （1）声明学生类，包含姓名和年龄
 * （2）添加几个学生对象到一个ArrayList集合中
 * （3）对集合中的学生进行操作，找出年龄大于30岁的，并取出第一个学生，
 * 		如果没有这样的学生，用无参构造new一个学生对象，打印学生信息
 */
public class Exer2 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("张三", 23));
		// list.add(new Student("李四", 34));
		list.add(new Student("王五", 25));
		list.add(new Student("杨六", 27));
		Student stu = list.stream().filter(s -> s.getAge() > 30).findFirst().orElse(new Student());
		System.out.println("学生的年龄：" + stu.getAge());
	}
}

class Student {
	private String name;
	private int age;

	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
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

}