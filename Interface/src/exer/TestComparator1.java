package exer;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator1 {
	public static void main(String[] args) {
		Employees[] emp = new Employees[5];
		emp[0] = new Employees(1,"张三",13000);
		emp[1] = new Employees(3,"王五",14000);
		emp[2] = new Employees(2,"李四",13000);
		emp[3] = new Employees(4,"赵六",7000);
		emp[4] = new Employees(5,"钱七",9000);
		System.out.println("员工列表：");
		for (int i = 0; i < emp.length; i++) {
			System.out.println(emp[i]);
		}
		
		sortS(emp);
		System.out.println("按工资排序后：");
		for (int i = 0; i < emp.length; i++) {
			System.out.println(emp[i]);
		}
		
		sortI(emp);
		System.out.println("按编号排序后：");
		for (int i = 0; i < emp.length; i++) {
			System.out.println(emp[i]);
		}
	}

//BubSalaryComparator
	private static void sortS(Object[] arr){
		EmpSalaryComparator esc = new EmpSalaryComparator();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(esc.compare(arr[j], arr[j + 1]) > 0){
					Object temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

//BubIdComparator{
	private static void sortI(Object[] arr){
		EmpIdComparator eic = new EmpIdComparator();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(eic.compare(arr[j], arr[j + 1]) > 0){
					Object temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
class EmpSalaryComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Employees e1 = (Employees) o1;
		Employees e2 = (Employees) o2;
		return Double.compare(e1.getSalary(), e2.getSalary());
	}
	
}
class EmpIdComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Employees e1 = (Employees) o1;
		Employees e2 = (Employees) o2;
		return e1.getId() - e2.getId();
	}
	
}
class Employees{
	private int id;
	private String name;
	private double salary;
	public Employees() {
		super();
	}
	public Employees(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}