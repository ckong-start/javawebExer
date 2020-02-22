package exer1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestZhuanHuanLiu {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fw.txt");
		FileOutputStream fos = new FileOutputStream("fw_1.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		char[] cbuf = new char[20];
		int len;
		while((len = isr.read(cbuf)) != -1){
			osw.write(cbuf, 0, len);
		}
		osw.close();
		isr.close();
	}
}
