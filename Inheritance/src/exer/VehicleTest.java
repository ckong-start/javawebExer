package exer;

public class VehicleTest {
	public static void main(String[] args) {
		Vehicle car = new Car();
		car.move();
	}
}
abstract class Vehicle{
	abstract void move();
}
class Car extends Vehicle{
	void move(){
		System.out.println("车能在路面上飞驰");
	}
}
class Plane extends Vehicle{

	void move() {
		System.out.println("飞机能在天空中翱翔");
	}
	
}
class Ship extends Vehicle{

	void move() {
		System.out.println("船能在大海里漫游");
	}
	
}