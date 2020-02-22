package exercise;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterTest {
	public static void main(String[] args) throws IOException {
		File file1 = new File("hi.txt");
		if(!file1.exists()){
			file1.createNewFile();
			System.out.println("hi.txt文件创建成功");
		}else{
			System.out.println("已经存在，创建失败");
		}
		File file2 = new File("hello.txt");
		FileReader fr = new FileReader(file2);
		FileWriter fw = new FileWriter(file1,true);
		char[] cbuf = new char[10];
		int len = 0;
		while((len = fr.read(cbuf)) != -1){
			fw.write(cbuf, 0, len);
		}
		
		fw.write("写入成功");
		fr.close();
		fw.close();
		
	}
}
