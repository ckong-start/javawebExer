package classobjectexer;

/*
 * 定义 类Student，包含三个属性：学号 number(int)，年级 state(int) ，成绩 score(int)。 
 * 创建 20 个学生对象，号为 1到20 ，年级和成绩都由随机数 确定。
 * 问题一：打印 出3年级 (state 值为 3）的学生信息 。
 * 问题二：使用冒泡排序按学生成绩，并遍历所有信息
 */
public class StudentExer {
	public static void main(String[] args) {
		////声明Student类型的数组
		Student[] stus = new Student[20];
		for(int i = 0;i < stus.length; i++){
			//给数组元素赋值
			stus[i] = new Student();
			//给Student对象的属性赋值
			stus[i].number = i + 1;
			//年级：[1,6]
			stus[i].state = (int)(Math.random() * 6 + 1);
			//成绩：[0,100]
			stus[i].score = (int)(Math.random() * 99);			
		}
		//遍历学生数组
		for(int i = 0;i < stus.length;i++){
			System.out.println(stus[i].info());
		}
		System.out.println("***************************");
		//问题一：打印出3年级(state值为3）的学生信息。
		for(int i = 0;i < stus.length;i++){
			if(stus[i].state == 3)
				System.out.println(stus[i].info());
		}
		System.out.println("***************************");
		//问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
		for(int i = 0;i < stus.length - 1;i++){
			for(int j = 0;j < stus.length - 1 - i;j++){
				if(stus[j].score > stus[j + 1].score){
					//如果需要换序，交换的是数组的元素：Student对象！！！
					Student temp = stus[j];
					stus[j] = stus[j + 1];
					stus[j + 1] = temp;
				}
			}
		}
		//遍历
		for(int i = 0;i < stus.length;i++){
			System.out.println(stus[i].info());
		}
	}
}

class Student {
	int number;// 学号
	int state;// 年级
	int score;// 分数
	
	//显示学生信息的方法
	public String info() {
		return "学号：" + number + "，年级：" + state + "，分数：" + score;
	}
}