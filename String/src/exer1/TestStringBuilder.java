package exer1;

public class TestStringBuilder {
	public static void main(String[] args) {
		String s = "hello";
		StringBuilder strb = new StringBuilder(s);
		strb.append("acb");
		System.out.println(strb);
		strb.append("asf");
		System.out.println(strb);
		strb.insert(2, "java");
		System.out.println(strb);
		strb.reverse();
		System.out.println(strb);
	}
}
