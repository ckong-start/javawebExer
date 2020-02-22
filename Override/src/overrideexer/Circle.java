package overrideexer;

public class Circle {
	private double radius;

	public Circle() {
		radius = 1;
	}
	
	/**
	 * 
	 * @param radius 圆的半径
	 * 
	 */
	public Circle(double radius) {
		this.radius = radius;
	}


	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double findArea(){//计算圆的面积
		return Math.PI * radius * radius;
	}
	
}
