package arrayexer;

/*
 * 数组的查找：
 * 线性查找与二分法查找。
 */
public class ArrExer3 {
	public static void main(String[] args) {
		// 首先定义数组并赋值
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 90 + 10);
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// 线性查找
		boolean isFlag = true;
		int dest = (int) (Math.random() * 90 + 10);
		System.out.println("要找的元素为：" + dest);
		for (int i = 0; i < arr.length; i++) {
			if (dest == arr[i]) {
				System.out.println("找到了该元素，在" + i + "位置。");
				isFlag = false;
				break;
			}

		}
		if (isFlag) {
			System.out.println("没有找到该元素。");
		}
		System.out.println("******************************");
		// 二分法查找
		// 查找的数组必须是有序的。
		System.out.println("下面为二分法查找：" + "\n" + "要找的元素为：" + dest);
		int[] arr1 = new int[]{12,23,25,34,37,47,53,60,76,83,92};
		int head = 0;// 初始的首索引
		int end = arr1.length - 1;// 初始的末索引
		boolean isFlag1 = true;
		while (head <= end) {
			int mid = (head + end) / 2;
			if (dest == arr1[mid]) {
				System.out.println("找到了该元素，在" + mid + "位置。");
				isFlag1 = false;
				break;
			} else if (dest > arr1[mid]) {
				head = mid + 1;
			} else {// (dest < arr1[mid])
				end = mid -1;
			}

		}
		if (isFlag1) {
			System.out.println("没有找到该元素。");
		}
	}
}
