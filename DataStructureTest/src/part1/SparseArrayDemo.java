package part1;

public class SparseArrayDemo {
	public static void main(String[] args) {
	  /*0 0 0 0 0 0 0 0 0 0 0
		0 0 1 0 0 0 0 0 0 0 0
		0 0 0 2 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0
		0 0 0 0 0 0 0 0 0 0 0*/
		//将以上的数据用普通二维数组保存
		int[][] arr = new int[11][11];
		arr[1][2] = 1;
		arr[2][3] = 2;
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 0)
					total++;
			}
		}
		
		//创建稀疏数组
		int[][] sparseArr = new int[total + 1][3];
		sparseArr[0][0] = arr.length;
		sparseArr[0][1] = arr[0].length;
		sparseArr[0][2] = total;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 0) {
					sparseArr[++count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = arr[i][j];
				}
			}
		}
	
		//从稀疏数组恢复到二维数组
		int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
		for (int i = 0; i < sparseArr[0][2]; i++) {
			arr2[sparseArr[i + 1][0]][sparseArr[i + 1][1]] = sparseArr[i + 1][2];
		}
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
