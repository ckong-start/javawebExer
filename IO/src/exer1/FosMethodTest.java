package exer1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FosMethodTest {

	@Test
	public void test1() throws IOException{
		FileOutputStream fos = new FileOutputStream("a.txt");
		byte[] b = "abddjlfjdlk".getBytes();
		fos.write(b);
		fos.close();
	}
	@Test
	public void test2() throws IOException{
		FileOutputStream fos = new FileOutputStream("a.txt");
		byte[] b = "abc".getBytes();
		fos.write(b);
		fos.write("\r\n".getBytes());
		fos.write("def".getBytes());
		fos.close();
	}
	@Test
	public void test3() throws IOException{
		FileInputStream fis = new FileInputStream("a.txt");
		byte[] buffer = new byte[5];
		int len;
		while((len = fis.read(buffer)) != -1){
			System.out.println(len);
		}
	}
}
