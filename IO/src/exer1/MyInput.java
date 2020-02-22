package exer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInput {
	public static String readString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = "";
		try {
			string = br.readLine();
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return string;
	}
	public static int readInt(){
		return Integer.parseInt(readString());
	}
	public static byte readByte(){
		return Byte.parseByte(readString());
	}
	public static short readShort(){
		return Short.parseShort(readString());
	}
	public static long readLong(){
		return Long.parseLong(readString());
	}
	public static float readFloat(){
		return Float.parseFloat(readString());
	}
	public static double readDouble(){
		return Double.parseDouble(readString());
	}
	public static boolean readBoolean(){
		return Boolean.parseBoolean(readString());
	}
	
}
