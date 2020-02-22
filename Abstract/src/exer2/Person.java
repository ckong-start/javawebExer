package exer2;

public class Person {
	private String name;
	private int age;
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
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
	public void keepPet(Animal a,String something){
		System.out.print(age + "岁的" + name + "正在喂养");
		a.eat(something);
		if(a instanceof Cat){
			Cat cat = (Cat) a;
			cat.catchMouse();
		}else if(a instanceof Dog){
			Dog dog = (Dog) a;
			dog.lookHome();
		}else
			throw new RuntimeException("数据类型不匹配");
	}
	/*public void keepPet(Dog dog,String something){
		dog.eat(something);
	}
	public void keepPet(Cat cat,String something){
		cat.eat(something);
	}*/
}
