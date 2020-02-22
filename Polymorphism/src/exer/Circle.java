package exer;

public class Circle extends GeometircObject {
	private double radius;

	public Circle(String color, double weight, double radius) {
		super(color, weight);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea(){
//		return 3.14 * radius * radius;
		return 3.14 * getRadius() * getRadius();
	}
}
