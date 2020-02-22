package p2.bean;

public class Customer {
	// 客户编号
	private int id; 
	// 客户姓名
	private String name;
	// 客户性别
	private char gender;
	// 客户年龄
	private int age;
	// 客户电话
	private String phone;
	// 客户邮箱
	
	private static int num = 1;
	
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		Customer.num = num;
	}
	private String email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer() {
		this.id = num++;
	}
	public Customer(/*int id, */String name, char gender, int age, String phone, String email) {
		super();
		this.id = num++;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	
}

