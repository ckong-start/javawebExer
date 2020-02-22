package arrayexer;

import java.util.Arrays;

/*
 * 创建一个长度为10的一维数组。并随即赋值(10-99)，求数组中的最大值、最小值、总和与平均数。
 * 拓展：数组的反转。
 */
public class ArrExer2 {
	public static void main(String[] args) {
		//定义数组并赋值
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 90 + 10);
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		//求最大值、最小值、总和与平均数
		int maxValue = arr[0],minValue = arr[0];
		int sum = 0;
		for(int i = 0; i < arr.length;i++){
			if(maxValue < arr[i]){
				maxValue = arr[i];
			}
			if(minValue > arr[i]){
				minValue = arr[i];
			}
			sum += arr[i];
		}
		System.out.println("数组中最大值是：" + maxValue);
		System.out.println("数组中最小值是：" + minValue);
		System.out.println("数组总和是：" + sum);
		System.out.println("数组平均值是：" + sum / arr.length);
		
		//数组的反转
		for(int i = 0;i < arr.length / 2;i ++){
 
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 -i];
			arr[arr.length - 1 -i] = temp;
		}		
		System.out.println("下面为数组反转后的结果：");
		System.out.println(Arrays.toString(arr));
		//数组的反转方式二：
//		for(int i = 0,j = arr.length - 1;i < j;i++,j--){
//			String temp = arr[i];
//			arr[i] = arr[j];
//			arr[j] = temp;	
//		}
	}
}
