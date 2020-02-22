package exer;

public class GeometricTest {

	public static void main(String[] args) {
		GeometricTest test = new GeometricTest();
		Circle c1 = new Circle("red", 1.0, 3.3);
		test.displayGeometricObject(c1);
		Circle c2 = new Circle("red", 1.0, 2.3);
		test.displayGeometricObject(c2);
		test.equalsArea(c1, c2);
		boolean isEquals = test.equalsArea1(c1, c2);
		System.out.println("c1 和 c2的面积是否相等：" + isEquals);
		MyRectangle m1 = new MyRectangle("blue", 1.0, 2.3, 3.2);
		test.displayGeometricObject(m1);

	}

	public void equalsArea(GeometircObject g1, GeometircObject g2) {
		if (g1.findArea() == g2.findArea()) {
			System.out.println("两者面积相等");
			return;
		}
		System.out.println("两者面积不同");
	}

	public boolean equalsArea1(GeometircObject g1, GeometircObject g2) {
		return g1.findArea() == g2.findArea();
	}

	public void displayGeometricObject(GeometircObject g) {
		// double b = g.findArea();
		// System.out.println("面积为：" + b);
		System.out.println("面积为：" + g.findArea());
	}
}
