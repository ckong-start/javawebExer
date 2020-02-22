package exer1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try {
			fis = new FileInputStream("fw.txt");
			fos = new FileOutputStream("fw_1.txt");
			isr = new InputStreamReader(fis);
			osw = new OutputStreamWriter(fos);

			char[] cbuf = new char[20];
			int len;
			while ((len = isr.read(cbuf)) != -1) {
				osw.write(cbuf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(osw != null)
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(isr != null)
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
}
