package exer;

import java.util.Arrays;

public class Day04 {
	public static void main(String[] args) {
		Day04.test8();
	}
	
	public static void test1() {
		// 数组的遍历
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void test2() {
		// 数组的求和
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum = " + sum);

		// 获取数组的最大值
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			max = max > arr[i] ? max : arr[i];
		}
		System.out.println("max = " + max);

		// 获取数组的平均值
		double avg = sum * 1.0 / arr.length;
		System.out.println("avg = " + avg);
	}

	public static void test3() {
		// （1）在编程竞赛中，有10位评委为参赛的选手打分，
		// 分数分别为：5，4，6，8，9，0，1，2，7，3
		// （2）求选手的最后得分（去掉一个最高分和一个最低分后其余8位评委打分的平均值）
		int arr[] = new int[] { 5, 4, 6, 8, 9, 0, 1, 2, 7, 3 };
		int min = arr[0];
		int max = arr[0];
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			min = min <= arr[i] ? min : arr[i];
			max = max >= arr[i] ? max : arr[i];
			sum += arr[i];
		}
		sum = sum - min - max;
		double avg = sum * 1.0 / (arr.length - 2);
		System.out.println("avg = " + avg);
	}

	public static void test4() {
		// 线性查找元素,第一次出现的索引位置
		int[] arr = { 11, 22, 33, 44, 55, 22, 45, 22, 54, 22 };
		int num = 22;
		boolean isFlag = true;
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				isFlag = false;
				System.out.println("指定元素" + num + "在数组中出现的第一次索引是" + i);
				break;
			}
		}
		if (isFlag) {
			System.out.println("指定元素" + num + "在数组中找不到");
		}
	}

	public static void test5() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		// 二分法查找元素,只能查找排好序的数组
		int value = 9;
		int index = -1;
		int left = 0;
		int right = arr.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (value == arr[mid]) {
				index = mid;
				break;
			} else if (value < arr[mid]) {
				right = mid - 1;
			} else if (value > arr[mid]) {
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
		if (index != -1) {
			System.out.println(value + "的下标是" + index);
		} else {
			System.out.println(value + "不存在");
		}

		// 数组的反转，对arr数组进行反转
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void test6() {
		int arr[] = new int[] { 5, 4, 6, 8, 9, 0, 1, 2, 7, 3 };
		// 冒泡排序
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	

	public static void test7() {
		// 简单使用二维数组
		String[][] employees = { 
				{ "10", "1", "段誉", "22", "3000" },
				{ "13", "2", "令狐冲", "32", "18000", "15000", "2000" }, 
				{ "11", "3", "任我行", "23", "7000" },
				{ "11", "4", "张三丰", "24", "7300" }, 
				{ "12", "5", "周芷若", "28", "10000", "5000" },
				{ "11", "6", "赵敏", "22", "6800" }, 
				{ "12", "7", "张无忌", "29", "10800", "5200" },
				{ "13", "8", "韦小宝", "30", "19800", "15000", "2500" }, 
				{ "12", "9", "杨过", "26", "9800", "5500" },
				{ "11", "10", "小龙女", "21", "6600" }, 
				{ "11", "11", "郭靖", "25", "7100" },
				{ "12", "12", "黄蓉", "27", "9600", "4800" } 
				};
		// 其中"10"代表普通职员，"11"代表程序员，"12"代表设计师，"13"代表架构师
		System.out.println("员工类型\t编号\t姓名\t年龄\t薪资\t奖金\t股票\t");
		for (int i = 0; i < employees.length; i++) {
			switch (employees[i][0]) {
			case "10":
				System.out.print("普通员工");
				break;
			case "11":
				System.out.print("程序员");
				break;
			case "12":
				System.out.print("设计师");
				break;
			case "13":
				System.out.print("架构师");
				break;
			}
			for (int j = 1; j < employees[i].length; j++) {
				System.out.print("\t" + employees[i][j]);
			}
			System.out.println();
		}
	}
	//选择排序
	public static void test8(){
		int arr[] = new int[] { 5, 4, 6, 8, 9, 0, 1, 2, 7, 3 };
		int index;
		for (int i = 0; i < arr.length; i++) {
			index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[index] > arr[j])index = j;
			}
			if(index != i){
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}


