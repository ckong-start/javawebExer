package exercise;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordCount {
	public static void main(String[] args) throws IOException{
		//1.创建map集合
		Map<Character,Integer> map = new HashMap<>();
		FileReader fr = null;
		BufferedWriter bw = null;
		
		try {
			//2.遍历每一个字符，每一个字符出现的次数放到map中
			fr = new FileReader("hello.txt");
			int c = 0;
			while ((c = fr.read()) != -1) {
				//int还原char
				char ch = (char) c;
				//判断char是否在map中第一次出现
				if (map.get(ch) == null) {
					map.put(ch, 1);
				} else {
					map.put(ch, map.get(ch) + 1);
				}
			}
			//3.把map中数据存到文件中
			//3.1 创建BufferedWriter
			bw = new BufferedWriter(new FileWriter("hello1.txt"));
			//3.2 遍历map，再写入数据
			Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
			for (Map.Entry<Character, Integer> entry : entrySet) {
				switch (entry.getKey()) {
				case ' ':
					bw.write("空格=" + entry.getValue());
					break;
				case '\t':
					bw.write("tab键=" + entry.getValue());
					break;
				case '\r':
					bw.write("回车=" + entry.getValue());
					break;
				case '\n':
					bw.write("换行=" + entry.getValue());
					break;
				default:
					bw.write(entry.getKey() + entry.getValue());
					break;
				}
				bw.newLine();
			} 
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				//4.关流
				if (bw != null)
					bw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
