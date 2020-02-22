package exer;

import java.io.File;

import org.junit.Test;

public class FileMethodTest {

	@Test
	public void test(){
		File f1 = new File("abc\\a.txt");
		System.out.println(f1.getName());
		System.out.println(f1.getAbsolutePath());
		System.out.println(f1.getPath());
	}
	
	@Test
	public void test1(){
		File file = new File("D:\\");
		String[] list = file.list();
		for (String str : list) {
			System.out.println(file.getAbsolutePath() + str);
		}
	}
	@Test
	public void test2(){
		File file = new File("D:\\");
		File[] listFiles = file.listFiles();
		for (File f : listFiles) {
			if(f.isFile())System.out.println("文件：" + f);
			else System.out.println("目录：" + f);
		}
	}
	
	
}	
