package exer;

public class CylinderTest {
	public static void main(String[] args) {
		// Cylinder c = new Cylinder(2.0, 3.0);
		Cylinder c = new Cylinder();
		c.setValue(2.0, 3.0);
		c.printDetails();
		System.out.println("底面积： " + c.getArea());
		System.out.println("体积： " + c.getVolume());
		boolean flag = c.setRH(3.0, 5.0);
		if(!flag)System.out.println("赋值失败！");
		else c.printDetails();
	}
}

class Cylinder {
	double radius, height;

	public Cylinder() {
	}

	// public Cylinder(double radius, double height) {
	// this.radius = radius;
	// this.height = height;
	// }

	public void printDetails() {
		System.out.println("圆柱体的底边半径是：" + radius + " 高是：" + height + " 底面积为：" + 3.14 * radius * radius + " 体积为："
				+ 3.14 * radius * radius * height);
	}

	public double getArea() {
		return 3.14 * radius * radius;
	}

	public double getVolume() {
		return getArea() * height;
	}

	public void setValue(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	public boolean setRH(double radius, double height) {
		if (radius <= 0.0 || height <= 0.0)
			return false;
		setValue(radius, height);
		return true;
	}
}