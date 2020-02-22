package exer;

import java.util.Scanner;
import java.util.Vector;

/*
 * 包装类的使用
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
 * 最高分，并输出学生成绩等级。
 * 
 */
public class ScoreTest {
	public static void main(String[] args) {

		// Scanner实例化
		Scanner scan = new Scanner(System.in);

		// 创建Vector对象
		Vector v = new Vector();

		// 通过for(;;)循环读取学生成绩
		int maxScore = 0;
		for (;;) {
			System.out.println("请输入学生成绩（以负数代表输入结束）：");
			int score = scan.nextInt();
			if (score < 0)
				break;
			if (score > 100) {
				System.out.println("输入数据非法，请重新输入！");
				continue;
			}
			v.addElement(score);// 自动装箱，将基本数据类型转化为包装类。

			// 在循环中比较出最大数
			if (maxScore < score)
				maxScore = score;
		}

		// 取出输入的成绩，并给它们分级。
		char level;
		for (int i = 0; i < v.size(); i++) {
			Object obj = v.elementAt(i);
			int score = (int) obj;
			if (maxScore - score <= 10) {
				level = 'A';
			} else if (maxScore - score <= 20) {
				level = 'B';
			} else if (maxScore - score <= 30) {
				level = 'C';
			} else
				level = 'D';

			System.out.println("Student" + (i + 1) + " score is " 
			+ score + " , level is " + level);
		}
	}
}
