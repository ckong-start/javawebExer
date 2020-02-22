package exer;

public class TestEmployee {
	public static void main(String[] args) {
		Employee[] emArr = new Employee[5];
		emArr[0] = new Employee(1, "张三", 13000);
		emArr[1] = new Employee(2, "李四", 13000);
		emArr[2] = new Employee(3, "王五", 14000);
		emArr[3] = new Employee(4, "赵六", 7000);
		emArr[4] = new Employee(5, "钱七", 9000);
		myArraysBub.sort(emArr);
		for (int i = 0; i < emArr.length; i++) {
			System.out.println(emArr[i]);
		}
	}
}

// 冒泡排序
class myArraysBub {
	public static void sort(Object[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				//将arr[j]强制为Comparable接口类型，目的是调用compareTo方法
				//当然如果数组的元素没有实现这个接口，那么将会发生ClassCastException
				Comparable c = (Comparable) arr[j];
				if (c.compareTo(arr[j + 1]) > 0) {
					Object temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}

// 选择排序
class myArraysSel {
	public static void sort(Object[] arr) {
		int index;
		for (int i = 0; i < arr.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < arr.length; j++) {
				Comparable c = (Comparable) arr[index];
				if (c.compareTo(arr[j]) > 0) {
					index = j;
				}
			}
			if (index != i) {
				Object temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}
}

class Employee implements Comparable {
	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary) {
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

	public Employee() {
		super();
	}

	@Override
	public int compareTo(Object o) {
		Employee em = (Employee) o;
		if (this.salary != em.salary) {
			if (this.salary > em.salary)
				return 1;
			else if (this.salary < em.salary)
				return -1;
			else
				return 0;
		}
		return this.id - em.id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}