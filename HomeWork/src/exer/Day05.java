package exer;

import java.util.Arrays;

public class Day05 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3, 2,1};

		int[] arr1 = { 1, 2, 3, 4, 3, 2, 1 };
		Test3(50);
	}

	public static void Test1() {
		int[] arr = { 10, 20, 30, 40, 50, 60, 66, 70, 80, 99 };
		System.out.println("您的大乐透号码为：");
		System.out.println(Arrays.toString(arr));
	}

	public static void Test2() {
		String[] str1 = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] str2 = { "黑桃", "红桃", "梅花", "方片" };
		for (int i = 0; i < str2.length; i++) {
			for (int j = 0; j < str1.length; j++) {
				System.out.print(str2[i] + str1[j] + " ");
			}
			System.out.println();
		}
	}

	public static void Test3(int num) {
		String[] str1 = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] str2 = { "黑桃", "红桃", "梅花", "方片" };
		String[][] str = new String[4][13];
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				str[i][j] = str2[i] + str1[j];
			}
		}
/*
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				System.out.print(str[i][j] + " ");
			}
			System.out.println();
		}
 */
		int i = num / 14;
		int j = (num - i * 13 - 1) % 13;
		System.out.println(str[i][j]);
		
	}

	public static void Test4() {
		char[] c = { 'a', 'l', 'f', 'm', 'f', 'o', 'b', 'b', 's', 'n' };
		char[] c1 = new char[26];
		int[] i1 = new int[26];
		for (int i = 0; i < c1.length; i++) {
			c1[i] = (char) (97 + i);
		}
		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if(c1[i] == c[j]){
					i1[i] += 1;
				}
			}
		}
		for (int i = 0; i < c1.length; i++) {
			if(i1[i] == 0)continue;
			System.out.println(c1[i] + "--" + i1[i]);
		}

	}

	public static void Test5() {
		int[] arr = { 95, 92, 75, 56, 98, 71, 80, 58, 91, 91 };
		int count = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avg = sum * 1.0 / arr.length;
		for (int i = 0; i < arr.length; i++) {
			count += avg > arr[i] ? 1 : 0;
		}
		System.out.println("高于平均分：" + avg + "的个数有" + count + "个");
	}

	public static void Test6(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] == arr[arr.length - 1 - i]) {
				count++;
			}
		}
		System.out.print(Arrays.toString(arr));
		if (count == arr.length / 2) {
			System.out.println("是否对称：true");
		} else {
			System.out.println("是否对称：false");
		}
	}

	public static void Test7(int[] arr, int[] arr1) {
		int len1 = arr.length;
		int len2 = arr1.length;
		int len = len1 < len2 ? len1 : len2;
		int count = 0;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
		System.out.print("是否一致：");
		if (len1 == len2) {//先确认数组长度是否一致
			for (int i = 0; i < len; i++) {//如果数组长度一致，则比较数组每个元素内容是否一致
				if (arr[i] == arr1[i])
					count++;//元素内容相同则计数器+1
			}
			if (count == len1) {//如果计数器累加后的数字与数组长度一样，则为相同的数组
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		} else {
			System.out.println(false);
		}
	}
	public static void Test8() {
		int[] arr = {26,67,49,38,52,66,7,71,56,87};
		System.out.println("原数组：" + "\n" + Arrays.toString(arr));
		for (int i = 0; i < arr.length / 2; i++) {
			if(arr[i] % 2 == 0){
				for(int j = arr.length - 1;j > arr.length / 2;j--){
					if(arr[j] % 2 == 1){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						break;
					}
				}
			}
		}
		System.out.println("排序后：" + "\n" + Arrays.toString(arr));
	}
	public static void Test8_1() {
		int[] arr = {26,67,49,38,52,66,7,71,56,87};
		System.out.println("原数组：" + "\n" + Arrays.toString(arr));
		int start = 0,end = arr.length - 1;
		while(start < end){//指针相交后停止
			while(arr[start] % 2 == 1){//从头开始找偶数，找到后停止
				start++;
			}
			while(arr[end] % 2 == 0){//从尾找奇数，找到后停止
				end--;
			}
			int temp = arr[start];//交换
			arr[start] = arr[end];
			arr[end] = temp;
			start++;//指针自增、自减
			end--;
		}
		System.out.println("排序后：" + "\n" + Arrays.toString(arr));
	}
	
	public static void Test9() {
		int count = 0;
		int[] arr = {9,10,6,6,1,9,3,5,6,4};
		System.out.println("原数组：" + "\n" + Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] != 0 && arr[i] == arr[j]){
					arr[j] = 0;//将重复的元素置为0
					count++;//每置一次0便累加1
				}
			}
		}
		int[] arr1 = new int[arr.length - count];
		for (int i = 0,j = 0; i < arr1.length; i++) {
			if(arr[j] == 0)j++;//将旧数组元素赋值给新数组，遇到0就跳过
			arr1[i] = arr[j];
			j++;
		}
		System.out.println("排序后：" + "\n" + Arrays.toString(arr1));
	}
}
