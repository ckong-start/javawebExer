package exer1;
/*
 * 定义Shape抽象类，包含私有属性color，创建构造器为color赋值；包含计算周长的方法celPerimeter();
 * 定义子类Triangle，包含三边；定义子类Circle，包含半径radius；子类分别实现父类的计算周长功能。
 */
public class Test1 {
	public static void main(String[] args) {
		
	}
}
abstract class Shape{
	private String color;
	public Shape(){
		
	}
	public Shape(String color){
		this.color = color;
	}
	public abstract double celPerimeter();
}
class Triangle extends Shape{
	private double a;
	private double b;
	private double c;
	public Triangle(String color,double a,double b,double c){
		super(color);
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public double celPerimeter() {
		return a + b + c;
	}
	
}
class Circle extends Shape{
	double radius;
	public Circle(String color,double radius){
		super(color);
		this.radius = radius;
	}
	@Override
	public double celPerimeter() {
		return Math.PI * 2 * radius;
	}
	
}