package exer;

import java.io.File;

public class MethodTest {
	//使用递归来遍历文件夹
	public static void main(String[] args) {
		File file = new File("D:\\BaiduYunDownload");
		printDir(file);
	}
	public static void printDir(File file){
		File[] list = file.listFiles();
		for (File f : list) {
			if(f.isFile()){
				System.out.println("文件：" + f);
			}else {
				System.out.println("目录：" + f);
				printDir(f);
			}
		}
	}
}
