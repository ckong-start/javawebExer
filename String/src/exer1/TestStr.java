package exer1;

import org.junit.Test;

public class TestStr {
	public static final String s1 = "HelloWorld";
	public static final String s2;
	public static final String s3;
	public static final String s4;
	public static final String s5 = "Hello";
	public static final String s6 = "World";
	static {
		s2 = "HelloWorld";
		s3 = "Hello";
		s4 = "World";
	}
	public static void main(String[] args) {
		System.out.println(s1 == s2);//true
		System.out.println(s1 == (s3 + s4));//false
		System.out.println(s1 == (s5 + s6));//true
		
	}
	
	/*public boolean equals (Object anObject) ：将此字符串与指定对象进行比较。
	public boolean equalsIgnoreCase (String anotherString) ：将此字符串与指定对象进
	行比较，忽略大小写。*/
	@Test
	public void test1(){
		String s1 = "helloworld";
		String s2 = "helloworld";
		String s3 = "Helloworld";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equalsIgnoreCase(s3));
	}
	/*public int length () ：返回此字符串的长度。
	public String concat (String str) ：将指定的字符串连接到该字符串的末尾。
	public char charAt (int index) ：返回指定索引处的 char值。
	public int indexOf (String str) ：返回指定子字符串第一次出现在该字符串内的索引。
	public String substring (int beginIndex) ：返回一个子字符串，从beginIndex开始截取
	字符串到字符串结尾。
	public String substring (int beginIndex, int endIndex) ：返回一个子字符串，从
	beginIndex到endIndex截取字符串。含beginIndex，不含endIndex*/
	@Test
	public void test2(){
		String s1 = "helloworld";
		String s2 = "hello";
		String s3 = "world";
		System.out.println(s1.length());
		System.out.println((s1.concat(s2)).length());
		System.out.println(s1.concat(s3).charAt(5));
		System.out.println(s1.indexOf(4));
	}
	
	/*public char[] toCharArray () ：将此字符串转换为新的字符数组。
	public byte[] getBytes () ：使用平台的默认字符集将该 String编码转换为新的字节数组。
	public String replace (CharSequence target, CharSequence replacement) ：
		将与target匹配的字符串使用replacement字符串替换*/
	@Test
	public void test3(){
		String s1 = "helloworld";
		char[] array = s1.toCharArray();
		for(Object o : array){
			System.out.print(o + " ");
		}
		byte[] bs = s1.getBytes();
		for(Object o : bs){
			System.out.println(o);
		}
		String s2 = s1.replace("h", "H");
		System.out.println(s2);
	}
	
	/*public String[] split(String regex) ：将此字符串按照给定的regex（规则）拆分为字符
	串数组*/
	@Test
	public void test4(){
		String s = "abc@def@gh@@ijk";
		String[] split = s.split("@");
		for(Object o : split){
			System.out.println(o);
		}
		System.out.println(split.length);
	}
}
