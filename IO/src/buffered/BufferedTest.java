package buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedTest {
	
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("1-3.mp4");
		FileOutputStream fos = new FileOutputStream("copy.mp4");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		long start = System.currentTimeMillis();
		
		byte[] buff = new byte[1024];
		int len;
		while((len = bis.read(buff)) != -1){
			bos.write(buff, 0, len);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		bos.close();
		bis.close();
		
	}
}
