package exer1;

public class X5_3_6 {
	public static void main(String[] args) {
		Circle cir1 = new Circle(2.2);
		Circle cir2 = new Circle(3.5);
		System.out.println(cir1.area());
		System.out.println(cir1.perimeter());
		Cylinder cy1 = new Cylinder(2.4,5.0);
		Cylinder cy2 = new Cylinder(3.2,4.0);
		System.out.println(cy1.area());
		System.out.println(cy1.volume());
	}
}
interface Shape{
	public static final double PI = 3.14;
	public abstract double area();
}
class Circle implements Shape{
	private double radius;
	public Circle(){
		
	}
	public Circle(double radius){
		this.radius = radius;
	}
	@Override
	public double area() {//求面积
		return PI * radius * radius;
	}
	public double perimeter(){
		return PI * 2 * radius;
	}
	public void setRadius(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		return radius;
	}
}
class Cylinder extends Circle{
	double height;
	public Cylinder(){
		
	}
	public Cylinder(double radius,double height){
		super(radius);
		this.height = height;
	}
	public double area(){//求表面积
		return super.area() * 2 + super.perimeter() * height;
	}
	public double volume(){
		return super.area() * height;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

}