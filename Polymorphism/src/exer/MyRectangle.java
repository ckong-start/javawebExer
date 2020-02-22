package exer;

public class MyRectangle extends GeometircObject {
	private double width;
	private double height;
	
	public MyRectangle(String color, double weight, double width, double height) {
		super(color, weight);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getheight() {
		return height;
	}

	public void setheight(double height) {
		this.height = height;
	}
	
	public double findArea(){
//		return width * height;
		return getWidth() * getheight();
	}
}
