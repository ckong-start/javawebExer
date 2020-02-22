package Exer;

/*
 * 有一个交通工具接口类Vehicles，有work接口，有Horse类和Boat类分别实现Vehicles，
 * 创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat；
 * 有Person类，有name和Vehicles属性，在构造器中赋值，实例化“唐僧”，
 * 一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具。
 */
interface Vehicles {
	public abstract void work();
}

class Horse implements Vehicles {
	@Override
	public void work() {
		System.out.println("一般情况下用Horse作为交通工具");
	}
}

class Boat implements Vehicles {
	@Override
	public void work() {
		System.out.println("遇到大河时用Boat作为交通工具");
	}
}

class VehFactory {
	public static Vehicles getHorse() {
		return new Horse();
	}

	public static Vehicles getBoat() {
		return new Boat();
	}
}

class Person {
	String name;
	Vehicles veh;

	public Person() {

	}

	public Person(String name, Vehicles veh) {
		this.name = name;
		this.veh = veh;
	}
}

public class Test {
	public static void main(String[] args) {
		Vehicles v1 = VehFactory.getBoat();
		Vehicles v2 = VehFactory.getHorse();
		Person ts = new Person("唐僧", v2);
		v2.work();
		ts.veh = v1;
		v1.work();
	}
}