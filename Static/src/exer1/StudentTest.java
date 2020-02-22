package exer1;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student("张三",18);
		Student s2 = new Student("李四", 20);
		Student s3 = new Student("王五",19);
		Student s4 = new Student("杨六",21);
		System.out.println("学生姓名是" + s1.getName() + ",年龄为" + s1.getAge() + ",学号为" + s1.getNum());
		System.out.println("学生姓名是" + s2.getName() + ",年龄为" + s2.getAge() + ",学号为" + s2.getNum());
		System.out.println("学生姓名是" + s3.getName() + ",年龄为" + s3.getAge() + ",学号为" + s3.getNum());
		System.out.println("学生姓名是" + s4.getName() + ",年龄为" + s4.getAge() + ",学号为" + s4.getNum());
		System.out.println(s1.getNum());
		System.out.println(s4.getNum());
	}
}	
