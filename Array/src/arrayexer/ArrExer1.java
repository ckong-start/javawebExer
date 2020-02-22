package arrayexer;

/*
 * 创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机
 * 赋值。同时，要求元素的值各不相同。
 */
public class ArrExer1 {
	public static void main(String[] args) {
		int[] arr = new int[6];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = (int) (Math.random() * 30 + 1);

			for (int j = 0; j < i; j++) {

				if (arr[i] == arr[j]) {
					i--;
					break;
				}

			}

		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
