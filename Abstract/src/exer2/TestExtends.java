package exer2;

public class TestExtends {
	public static void main(String[] args) {
		Person p = new Person("Jack",23);
		Animal a1 = new Cat("小猫",2,"灰色");
		Animal a2 = new Dog("二哈",3,"黑白色");
		p.keepPet(a1, "🐟");
		p.keepPet(a2, "🥩");
	}	
}
	