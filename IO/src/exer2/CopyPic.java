package exer2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPic {
	public static void main(String[] args) throws IOException  {
		FileInputStream fis = new FileInputStream("a.jpg");
		FileOutputStream fos = new FileOutputStream("a_1.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		byte[] buffer = new byte[1024];
		int len;
		while((len = bis.read(buffer)) != -1){
			bos.write(buffer, 0, len);
		}
		
		bis.close();
		bos.close();
		fis.close();
		fos.close();
	}
}
