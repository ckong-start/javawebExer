package exer;

public class TestComparable {
	public static void main(String[] args) {
		Student s1 = new Student(1, "张三", 89);
		Student s2 = new Student(2, "李四", 89);
		int num = s1.compareTo(s2);
		if(num > 0)System.out.println("s1 > s2");
		else if(num < 0)System.out.println("s1 < s2");
		else System.out.println("s1 = s2");
	}
}
class Student implements Comparable{
	private int id;
	private String name;
	private int score;
	
	public Student() {
		super();
	}

	public Student(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Object o) {
		Student stu = (Student) o;
		if(this.score != stu.score){
			return this.score - stu.score;
		}else {
			return this.id - stu.id;
		}
	}
	
}
