package exer;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		Student s1 = new Student("张三",23);
		Student s2 = new Student("李四",23);
		Student s3 = new Student("王五",23);
		Student s4 = new Student("杨六",22);
		Student s5 = new Student("岳七",21);
		Student s6 = new Student("顾八",25);
		Student[] ss = new Student[]{s1,s2,s3,s4,s5,s6};
		System.out.println(Arrays.toString(ss));
		Arrays.sort(ss);
		System.out.println(Arrays.toString(ss));
	}
}
class Student implements Comparable<Student>{
	private String name;
	private int age;
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
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	@Override
	public int compareTo(Student o) {
		int result = this.age - o.age;
		if(result == 0){
			result = this.name.charAt(0) - o.name.charAt(0);
		}
		return result;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
	

}