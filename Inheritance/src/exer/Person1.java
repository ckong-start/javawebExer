package exer;

import javax.xml.crypto.Data;

public class Person1 {
	String name;
	String sex;
	int id;
	int age;
	String census;// 户籍
	Data data;

	public String toString() {
		return "身份证号：" + id + " 姓名：" + name + " 户籍：" + census;
	}

	public boolean equals(Person1 p) {
		if (this == p)
			return true;
		if (p instanceof Person1) {
			Person1 person = (Person1) p;
			return this.id == person.id && this.name.equals(person.name);
		}
		return false;
	}

	public static void main(String[] args) {
		Person1 p1 = new Person1();
		Person1 p2 = new Person1();
		p1.id = 123456;
		p2.id = 123456;
		p1.name = "jack";
		p2.name = "jack";
		p2.name = "jane";
		boolean b = p1.equals(p2);
		if (b)
			System.out.println("两个对象一样");
		else
			System.out.println("两个对象不同");
	}
}
