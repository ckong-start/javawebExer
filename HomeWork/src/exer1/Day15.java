package exer1;

import java.util.Arrays;

public class Day15 {
	public static void main(String[] args) {
		/*String p = getPropertySetMethodName("name");
		System.out.println(p);*/
		/*String str1 = "atguigu";
		String str2 = "woaiatguigu,atguigubutongyuxiaguigu,wulunatguiguhaishixiaguigu,zhaodaogongzuojiushihaodeatguigu";
		test2(str1,str2);*/
		/*test3("java","java woaijava,i like jajavava i enjoy java");*/
		/*test4_2("aDFGGuigddFETWBu");*/
		System.out.println(test5());
	}
	//获取长度为5的随机字符串，字符串由随机的4个大写英文字母和1个0-9之间（包含0和9）的整数组成
	public static String test5(){
		char[] chs = new char[26];
		String str = "";
		for (int i = 0; i < chs.length; i++) {
			chs[i] = (char) (65 + i);
		}
		for (int i = 0; i < 5; i++) {
			if(i != 4)str += chs[(int)(Math.random() * 26)];
			else str += (int)(Math.random() * 10);
		}
		
		/*for(Object o : chs){
			System.out.print(o);
		}*/
		return str;
	}
	//将字符数组中索引为偶数的元素变成'~'
	public static void test4_5(char[] ch){
		for (int i = 0; i < ch.length; i += 2) {
			ch[i] = '~';
		}
		System.out.println(ch);
	}
	//如果第一位和最后一位的内容不相同,则交换
	public static void test4_4(char[] ch){
		if(ch[0] != ch[ch.length - 1]){
			char temp = ch[ch.length - 1];
			ch[ch.length - 1] = ch[0];
			ch[0] = temp;
		}
		test4_5(ch);
	}
	//将字符数组中的所有大写字母变成小写字母(不能使用toLowerCase()方法)
	public static void test4_3(char[] ch){
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] >= 'A' && ch[i] <= 'Z'){
				ch[i] += 32;
			}
		}
		test4_4(ch);
	}
	//将该字符串变成字符数组(不能使用toCharArray()方法)
	public static void test4_2(String str){
		char[] ch = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		test4_3(ch);
	}
	
	public static void test3(String delStr, String scrStr){
		StringBuilder sb = new StringBuilder();
		String str = scrStr.replaceAll(delStr,"@");
		String[] split = str.split("@");
		/*for(Object o : split){
			System.out.println(o);
		}*/
		for(int i = 0;i < split.length;i++){
			sb.append(split[i]);
		}
		System.out.println(sb);
	}
	
	public static void test2(String smallStr, String bigStr){
		int index = 0;
		int count = 0;
		while(index < bigStr.length()){
			index = bigStr.indexOf(smallStr, index);
			if(index == -1)break;
			index++;
			count++;
		}
		System.out.println("count = " + count);
	}
	
	public static String getPropertySetMethodName(String property){
		String str = "set";
		char ch = property.charAt(0);
		ch -= 32;
		str += ch + property.substring(1);
		return str;
	}

	public static String getPropertyGetMethodName(String property){
		String str = "get";
		char ch = property.charAt(0);
		ch -= 32;
		str += ch + property.substring(1);
		return str;
	}
	
}
