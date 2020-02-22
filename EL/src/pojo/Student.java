package pojo;

public class Student {

	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private String phone;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, String name, String sex, Integer age, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", phone=" + phone + "]";
	}
	
	
}
