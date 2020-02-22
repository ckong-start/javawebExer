package exer2;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestWriter {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("fw.txt",true);
		String msg = "爱学习";
		fw.write(msg);
		fw.write(msg, 1, 2);
		fw.close();
	}
	
	@Test
	public void test() throws IOException{
		FileWriter fw = new FileWriter("a.txt");
		fw.write(98);
		fw.write("\r\n");
		char[] cbuf = {'a','b','c'};
		fw.write(cbuf);
		fw.write("\r\n");
		fw.write(cbuf, 1, 2);
		fw.close();
	}
}
