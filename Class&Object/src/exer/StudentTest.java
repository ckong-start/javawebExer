package exer;

public class StudentTest {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "linus";
		stu.gender = "male";
		stu.id = 1234;
		stu.age = 13;
		stu.score = 60;
		String s = stu.say();
		System.out.println(s);
	}

}

class Student {
	String name, gender;
	int age, id;
	double score;

	public String say() {
		return "name is " + name + " , gender = " + gender + " , age = " + age + " , id = " + id + " , score = "
				+ score;
	}
}
