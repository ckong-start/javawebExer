package exer1;

public class TestEnum {
	public static void main(String[] args) {
		System.out.println(Gender.getGirl());
		System.out.println(Gender.getBoy());
		System.out.println(Sex.BOY);
		System.out.println(Sex.GIRL);
		
	}
}
class Gender{
	private static final Gender BOY = new Gender();
	private static final Gender GIRL = new Gender();
	
	private Gender(){
		
	}

	public static Gender getBoy() {
		return BOY;
	}

	public static Gender getGirl() {
		return GIRL;
	}
}
enum Sex{
	BOY,GIRL;
	private String name;
	private int age;
	private Sex(){}
	private Sex(String name,int age){
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
	
}