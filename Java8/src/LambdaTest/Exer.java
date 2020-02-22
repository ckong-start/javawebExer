package LambdaTest;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Exer {
	
	public static void main(String[] args) {
		EmployeeSerice es = new EmployeeSerice();
		//所有员工对象
		System.out.println(1);
		es.get(t->true).forEach(t->System.out.println(t));
		//所有年龄超过35的员工
		System.out.println(2);
		es.get(t->t.getAge() > 35).forEach(t->System.out.println(t));
		//所有薪资高于15000的女员工
		System.out.println(3);
		es.get(t->t.getSalary() > 15000 && t.getGender() == '女').forEach(t->System.out.println(t));
		//所有编号是偶数的员工
		System.out.println(4);
		es.get(t->t.getId() % 2 == 0).forEach(t->System.out.println(t));
		//名字是“张三”的员工
		System.out.println(5);
		es.get(t->"张三".equals(t.getName())).forEach(t->System.out.println(t));
		//年龄超过25，薪资低于10000的男员工
		System.out.println(6);
		es.get(t->t.getAge() > 25 && t.getSalary() < 10000).forEach(t->System.out.println(t));
	}
}
class EmployeeSerice{
	private ArrayList<Employee> all;
	
	public ArrayList<Employee> get(Predicate<Employee> p){
		ArrayList<Employee> newList = new ArrayList<Employee>();
		for (Employee emp : all) {
			if(p.test(emp)){
				newList.add(emp);
			}
		}
		return newList;
	}
	
	public EmployeeSerice() {
		all = new ArrayList<Employee>();
		all.add(new Employee(1, "张三", '男', 33, 8000));
		all.add(new Employee(2, "翠花", '女', 23, 18000));
		all.add(new Employee(3, "无能", '男', 46, 8000));
		all.add(new Employee(4, "李四", '女', 23, 9000));
		all.add(new Employee(5, "老王", '男', 23, 15000));
		all.add(new Employee(6, "大嘴", '男', 23, 11000));
	}
	
}

class Employee{
	private int id;
	private String name;
	private char gender;
	private int age;
	private int salary;
		
	public Employee() {}
	
	public Employee(int id, String name, char gender, int age, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + 
				", name=" + name + 
				", gender=" + gender 
				+ ", age=" + age + 
				", salary=" + salary
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}