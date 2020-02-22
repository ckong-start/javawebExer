package exer;

import java.util.Arrays;

import org.junit.Test;

public class TestString {

	@Test
	public void Test1() {
		String str = "   fggdgd     ";
		String s = myTrim(str);
		System.out.println(s);
	}

	/*
	 * 1.模拟一个trim方法，去除字符串两端的空格。
	 */
	public String myTrim(String str) {
		if (str != null) {
			int begin = 0;
			int end = str.length() - 1;

			while (begin < end && str.charAt(begin) == ' ') {
				begin++;
			}
			while (begin < end && str.charAt(end) == ' ') {
				end--;
			}

			return str.substring(begin, end + 1);
		}
		return null;
	}

	@Test
	public void Test2() {
		String str = "abcdefg";
		System.out.println(reverse(str, 2, 5));
		System.out.println(reverse1(str, 2, 5));
	}

	/*
	 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为“abfedcg”。
	 */
	public String reverse(String str, int begin, int end) {
		if (str != null) {
			char[] arr = str.toCharArray();
			for (; begin < end; begin++, end--) {
				char c = arr[begin];
				arr[begin] = arr[end];
				arr[end] = c;
			}
			return new String(arr);
		}
		return null;
	}

	// 使用StringBuffer
	public String reverse1(String str, int begin, int end) {
		if (str != null) {
			StringBuffer sb = new StringBuffer(str.length());
			sb.append(str.substring(0, begin));
			for (int i = end; i >= begin; i--) {
				sb.append(str.charAt(i));
			}
			sb.append(str.substring(end + 1));

			return sb.toString();
		}
		return null;
	}

	/*
	 * 3.获取一个字符串在另一个字符串中出现的次数。 比如：获取“ab”在“abkkcadkabkebfkabkskab”中出现的次数。
	 */
	public int getCount(String mainStr, String subStr) {
		int index = 0;
		int count = 0;
		while ((index = mainStr.indexOf(subStr)) != -1) {
			count++;
			index += subStr.length();
		}

		return count;
	}

	/*
	 * 4.获取两个字符串中最大相同子串。比如：str1 = “abcwerthelloyuiodef”；str2 = “cvhellobnm”
	 * 提示：将段的哪个串进行长度依次递减的子串与较长的串比较。
	 */
	public String getMaxSameSubString(String str1, String str2) {
		String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
		String minStr = (str1.length() < str2.length()) ? str1 : str2;
		int len = minStr.length();
		for (int i = 0; i < len; i++) {
			for (int x = 0, y = len - i;y <= len;x++, y++) {
				String subStr = minStr.substring(x, y);
				if (maxStr.contains(subStr)) {
					return subStr;
				}
			}
		}

		return null;
	}
	@Test
	public void Test3(){
		String str = "ahffgsdfg";
		String ts = testSort(str);
		System.out.println(ts);
	}
	/*
	 * 5.对字符串中字符进行自然顺序排序。 
	 * 提示：1）字符串编程字符数组。 
	 * 2）对数组排序，选择，冒泡，Arrays。sort（）；
	 * 3）将排序后的数组变成字符串。
	 */
	public String testSort(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		String newStr = new String(arr);
		System.out.println(str);
		return newStr;
	}
}
