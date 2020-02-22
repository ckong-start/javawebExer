package arrayexer;

import java.util.Arrays;

/*
 * 冒泡排序法
 * 随机给个长度为10的一维数组，进行排序。
 */
public class BubbleSortTest {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i = 0;i < arr.length;i++){
			arr[i] = (int)(Math.random() * 100 + 1);
			System.out.print(arr[i] + " ");
		}
		for(int i = 0;i < arr.length - 1;i++){
			for(int j = 0;j < arr.length - i - 1;j++){
 
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(arr));
	}
}
