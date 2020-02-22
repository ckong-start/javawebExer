package mapexer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class TestPro {
	public static void main(String[] args) throws IOException {
		File file = new File("info.properties");
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream("info.properties");
		String str = "user=atguigu";
		byte[] bytes = str.getBytes();
		fos.write(bytes);
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("info.properties");
		pro.load(fis);
		String value = pro.getProperty("user");
		System.out.println(value);
		fis.close();
		fos.close();
	}
	public void test() throws IOException{
		FileInputStream fis = new FileInputStream("xxx");
		FileOutputStream fos = new FileOutputStream("xxx_1");
		InputStreamReader isr = new InputStreamReader(fis,"GBK");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		int len;
		char[] cbuf = new char[20];
		while((len = isr.read(cbuf)) != -1){
			osw.write(cbuf,0,len);
		}
		osw.close();
		isr.close();
		fos.close();
		fis.close();
	}
}
