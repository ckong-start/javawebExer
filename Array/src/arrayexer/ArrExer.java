package arrayexer;

import java.util.Scanner;

/*从键盘读入学生成绩，找出最高分
 * 并输出学生成绩等级。
 * 成绩>=最高分-10  等级为‘A’
 * 成绩>=最高分-20  等级为‘B’
 * 成绩>=最高分-30  等级为‘C’
 * 其余                         等级为‘D’
 * 提示：先读入学生人数，根据人数创建int数组，
 * 存放学生成绩。
 * 输出样式：student 0 score is 56 grade is D 
 */
public class ArrExer {
	public static void main(String[] args) {
		//1.使用Scanner，读取学生个数
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入学生人数：");
		int number = scan.nextInt();		
		
		//2.创建数组，来存储学生成绩：动态初始化
		int[] scores = new int[number];
		
		//3.给数组中的元素赋值
		int max = 0;
		for (int i = 0; i < scores.length; i++) {
			System.out.print("请输入学生成绩：");
			scores[i] = scan.nextInt();
			//4.获取数组中的元素的最大值：最高分
			if (max < scores[i]) {
				max = scores[i];								
			}			
		}
						
		//5.根据每个学生成绩与最高分的差值，得到每个学生的等级，并输出等级和成绩。
		for (int i = 0; i < scores.length; i++) {
			if ((max - scores[i]) <= 10){
				System.out.println("student " + i + " scores " + scores[i] + " grade is " + "A");
			}else if((max - scores[i]) <= 20){
				System.out.println("student " + i + " scores " + scores[i] + " grade is " + "B");
			}else if((max - scores[i]) <= 30){
				System.out.println("student " + i + " scores " + scores[i] + " grade is " + "C");				
			}else {
				System.out.println("student " + i + " scores " + scores[i] + " grade is " + "D");

			}
		}
		scan.close();
	}

}
