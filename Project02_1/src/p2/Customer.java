package p2;

public class Customer {
	private int id;// 客户编号
	private String name;// 客户姓名
	private char gender;// 性别
	private int age;// 年龄
	private String phone;// 电话号码
	private String email;// 电子邮箱
	private static int num = 1;
	
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

	public Customer(String name, char gender, int age, String phone, String email) {
		this.id = num++;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + gender + "\t" + age + "\t" + phone
				+ "\t" + email;
	}

}
