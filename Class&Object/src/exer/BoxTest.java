package exer;

public class BoxTest {
	public static void main(String[] args) {
		Box box = new Box(2.0, 1.0, 3.0);
		double volume = box.getVolume();
		System.out.println(volume);
	}
}

class Box {
	private double length;
	private double width;
	private double height;

	public Box() {
	}

	public Box(double length, double width, double height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public double getVolume() {
		return length * width * height;
	}
}