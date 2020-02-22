package exercise;

import java.io.File;

public class fileTest {
	//判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称。
	public static void main(String[] args) {
		File file = new File("d:\\things\\something");
		String[] list = file.list();
		for(String str : list){
			if(str.endsWith("jpg")){
				System.out.println(str);
			}
		}
	}
}
