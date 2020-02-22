package arrayexer;

import java.util.Arrays;

/*
 * 先由随机数给数组赋值，然后用排序方法给数组排序。
 */
public class BubbleSort1 {
	
	public static void main(String[] args) {
		// 创建一个长度为10的数组
		int[] arr = new int[10];
		arr(arr);
//		System.out.println("排序前" + Arrays.toString(arr));
//		selectSort(arr);
//		System.out.println("排序后" + Arrays.toString(arr));
//		bubbleSort(arr);
		bubbleSort1(arr);
	}

	public static void selectSort(int[] arr) {
		//以下为冒泡反排序
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public static void arr(int[] arr) {
		// 利用随机数给数组每个元素赋值并输出
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100 + 1);
		}
	}
	//冒泡排序
	public static void bubbleSort(int[] data) {
		int count1 = 0;
		System.out.println("开始排序");
		int arrayLength = data.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = temp;
				}
				count1++;
			}
		}
		System.out.println(java.util.Arrays.toString(data));
		System.out.println(count1);
	}
	//冒泡排序优化1
	public static void bubbleSort1(int[] data) {
		int count2 = 0;
		System.out.println("开始排序");
		int arrayLength = data.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = temp;
					flag = true;
				}
				count2++;
			}
			if (!flag)
				break;
		}
		System.out.println(java.util.Arrays.toString(data));
		System.out.println(count2);
	}
}
