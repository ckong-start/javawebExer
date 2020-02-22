package arrayexer;

import java.util.Scanner;

public class Exer {
	public static void main(String[] args) {
		System.out.print("请输入一个数字：");
		int len = new Scanner(System.in).nextInt();
		new Exer().RectangleTest1(len);
	}


/*
 * 回形数格式方阵的实现
 * 从键盘输入一个整数（1~20） 则以该数字为矩阵的大小，
 * 把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。
 * 例如： 输入数字2，则程序输出：   1 2 
 * 					      4 3 
 * 输入数字3，则程序输出：  1 2 3 
					 8 9 4 
					 7 6 5 
 输入数字4， 则程序输出： 
1   2   3   4 
12  13  14  5 
11  16  15  6 
10   9  8   7

 */
	//方式一
	public void RectangleTest(int len){
		int[][] arr = new int[len][len];
		int k = 1;
		int i = 0,j = 0; 
		int s = len * len;
		//k = 1向右;	k = 2向下; k = 3向左; k = 4向上.
		for(int m = 1;m <= s;m++){
			if(k == 1){
				if(j < len && arr[i][j] == 0){
					arr[i][j++] = m;
				}else {
					k = 2;
					i++;
					j--;
					m--;
				}
				
			}else if(k == 2){
				if(i < len && arr[i][j] == 0){
					arr[i++][j] = m;
				}else {
					k = 3;
					i--;
					j--;
					m--;
				}
				
			}else if(k == 3){
				if(j >= 0 && arr[i][j] == 0){
					arr[i][j--] = m;
				}else {
					k = 4;
					i--;
					j++;
					m--;
				}
				
			}else if(k == 4){
				if(i >= 0 && arr[i][j] == 0){
					arr[i--][j] = m;
				}else {
					k = 1;
					i++;
					j++;
					m--;
				}
				
			}
		}
		//遍历
		for(int m = 0;m < arr.length;m++){
			for(int n = 0;n < arr[m].length;n++){
				System.out.print(arr[m][n] + "\t");
			}
			System.out.println();
		}
	}
	
	//方式二
	public void RectangleTest1(int n){
	int[][] arr = new int[n][n];

	int count = 0; // 要显示的数据
	int maxX = n - 1; // x轴的最大下标
	int maxY = n - 1; // Y轴的最大下标
	int minX = 0; // x轴的最小下标
	int minY = 0; // Y轴的最小下标
	while (minX <= maxX) {
		for (int x = minX; x <= maxX; x++) {
			arr[minY][x] = ++count;
		}
		minY++;
		for (int y = minY; y <= maxY; y++) {
			arr[y][maxX] = ++count;
		}
		maxX--;
		for (int x = maxX; x >= minX; x--) {
			arr[maxY][x] = ++count;
		}
		maxY--;
		for (int y = maxY; y >= minY; y--) {
			arr[y][minX] = ++count;
		}
		minX++;
	}

	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr.length; j++) {
			String space = (arr[i][j] + "").length() == 1 ? "0" : "";
			System.out.print(space + arr[i][j] + " ");
		}
		System.out.println();
	}
	}
}