package exer2;

public class TestSingle {

	public static void main(String[] args) {
		SingleTon i1 = SingleTon.getInstance();
		SingleTon i2 = SingleTon.getInstance();
		SingleTon i3 = SingleTon.getInstance();
		System.out.println(i1 == i2);
		System.out.println(i1 == i3);
		System.out.println("====================");
		SingleTon1 in1 = SingleTon1.getInstance();
		SingleTon1 in2 = SingleTon1.getInstance();
		SingleTon1 in3 = SingleTon1.getInstance();
		System.out.println(in1 == in2);
		System.out.println(in1 == in3);
		System.out.println("====================");
		SingleTon2 int1 = SingleTon2.getInstance();
		SingleTon2 int2 = SingleTon2.getInstance();
		SingleTon2 int3 = SingleTon2.getInstance();
		System.out.println(int1 == int2);
		System.out.println(int1 == int3);
	}
}
