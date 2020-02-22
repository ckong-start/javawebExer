package exer2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class CopyVideo {
	
	@Test
	public void test() throws IOException{
		//造文件
		File srcFile = new File("小哥哥.mp4");
		File destFile = new File("小哥哥1.mp4");
		//造流
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		
		//读数据
		byte[] buffer = new byte[5];
		int len;
		while((len = fis.read(buffer)) != -1){
			fos.write(buffer, 0, len);
		}
		
		//关闭资源
		fis.close();
		fos.close();
	}
}
