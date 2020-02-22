package exer1;

import java.io.IOException;
import java.io.PrintStream;

public class TestDaYinLiu {

	public static void main(String[] args) throws IOException {
		System.out.println("abc");
		PrintStream ps = new PrintStream("b.txt");
		System.setOut(ps);
		System.out.println("1234abcdefg");
	}
}
