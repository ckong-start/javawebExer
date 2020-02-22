package exer;

/*
 * 定义一个Employee类，该类包含：
private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
abstract方法earnings()；
toString()方法输出对象的name,number和birthday。
 */
public abstract class Employee {
	private String name;
	private int number;
	private MyDate birthday;

	public abstract double earnings();

	public Employee() {
	}

	public Employee(String name, int number, MyDate birthday) {
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}
	

	public MyDate getBirthday() {
		return birthday;
	}

	public String toString() {
		return "name: " + name + ", number: " + number + ", birthday: " + birthday.toDateString();
	}

}
