package exer;

import java.io.*;

public class exTest1 {
	public static void main(String[] args) {
		
			method(0,1);
		
	}
	//throw 抛出一个异常对象
	//throws 异常声明
	public static void method(int num1, int num2){
		if(num1 == 0)
			try {
				throw new FileNotFoundException("文件没找到");
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
//				System.out.println("文件没找到");
			}
		if(num2 == 1)
			try {
				throw new IOException("IO异常");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		
	}
}
