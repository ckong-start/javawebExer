package exer;

public class Zi extends Fu{
	private int num1 = 6;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void show (){
		super.show();
		System.out.println("num1= " + num1);
	}
}
