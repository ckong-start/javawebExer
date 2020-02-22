package exer;

import java.util.Comparator;

public class TestComparator {
	public static void main(String[] args) {
		Students stu1 = new Students("张三",89);
		Students stu2 = new Students("李四",78);
		StudentScoreCompare ssc = new StudentScoreCompare();
		int num = ssc.compare(stu1, stu2);
		if(num > 0){
			System.out.println("s1 > s2");
		}else if(num < 0){
			System.out.println("s1 < s2");
		}else{
			System.out.println("s1 = s2");
		}
	}
}
class Students{
	private String name;
	private int score;
	public Students() {
		super();
	}
	public Students(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
}
class StudentScoreCompare implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Students s1 = (Students) o1;
		Students s2 = (Students) o2;
		return s1.getScore() - s2.getScore();
	}
	
}