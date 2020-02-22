package exercise;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
	public static void main(String[] args) {
		File file = new File("hello.txt");
		test2(file);
	}

	public static void test2(File file) {
		FileReader fr = null;
		try {
			fr = new FileReader(file);

			char[] cbuf = new char[6];
			int len;
			while ((len = fr.read(cbuf)) != -1) {
				/*for (int i = 0; i < len; i++) {
					System.out.print(cbuf[i]);
				}*/
				System.out.print(new String(cbuf,0,len));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void test1(File file) {
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			int data;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
