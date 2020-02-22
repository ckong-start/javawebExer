package exer;

public class CarTest {
	private String color;
	private String model;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CarTest() {
	}

	public CarTest(String color, String model) {
		this.color = color;
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "CarTest [color=" + color + ", model=" + model + "]";
	}
	public boolean equals(CarTest car){
		if(this == car)
			return true;
		if(car instanceof CarTest){
			CarTest c = (CarTest) car;
			return this.color.equals(car.color) && 
					this.model.equals(car.model);
		}
		return false;
	}
	
	public static void main(String[] args) {
		CarTest c1 = new CarTest();
		CarTest c2 = new CarTest();
		c1.color = "red";
		c1.model = "benz";
		c2.color = "white";
		c2.model = "audi";
		boolean b = c1.equals(c2);
		if(b)System.out.println("same");
		else System.out.println("no same");
	}
}
