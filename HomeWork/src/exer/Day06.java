package exer;

public class Day06 {
	public static void main(String[] args) {
//		compare(100,120);
//		getSum(6, 7, 2, 12, 2121);
		getString('a','c','b');
		
	}

	// 比较两个整数是否相等
	public static boolean compare(int a, int b) {
		/*if (a == b) {
			return true;
		} else {
			return false;
		}*/
		
//		return a == b ? true : false;
		return a == b;
	}

	// 计算1-100的和
	public static int getSum1() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}

	// 不确定的打印次数
	public static void printHelloWorld(int n) {
		for (int i = 0; i <= n;i++) {
			System.out.println("HelloWorld");
		}
	}

	// 打印1到指定范围内所有的质数
	public static void printPrime(int n) {
		boolean isFlag = true;
		for (int i = 2; i <= n; i++) {
			isFlag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isFlag = false;
					break;
				}
			}
			if (isFlag) {
				System.out.println(i);
			}
		}
	}
	
	//可变形参的使用
	public static int getSum(int...arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static void getString(char...c){
		String s = "";
		for(int i = 0;i < c.length;i++){
			s += c[i];
		}
		System.out.println(s);
	}
	
}