package exer;

import java.io.IOException;

public class exTest2 {
	public static void main(String[] args) {
		method();
	}
	public static int method(){
		
		try {
			throw new IOException("编译时错误");
		} catch (IOException e) {
			return 1;
		}finally{//finally里面的语句会先于return执行
			System.out.println(123);
		}
		
	}
}
