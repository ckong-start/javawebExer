package classobjectexer;

/*
 * 定义 类Student，包含三个属性：学号 number(int)，年级 state(int) ，成绩 score(int)。 
 * 创建 20 个学生对象，号为 1到20 ，年级和成绩都由随机数 确定。
 * 问题一：打印 出3年级 (state 值为 3）的学生信息 。
 * 问题二：使用冒泡排序按学生成绩，并遍历所有信息
 */
public class StudentExer1 {
	public static void main(String[] args) {
		Students[] stus = new Students[20];
		for(int i = 0;i < stus.length; i++){
			stus[i] = new Students();
			stus[i].number = i + 1;
			stus[i].state = (int)(Math.random() * 6 + 1);
			stus[i].score = (int)(Math.random() * 99);			
		}
		Methon test = new Methon();				
		//遍历输出
		test.print(stus);
		System.out.println("***************************");
		//问题一：
		test.searchstate(stus, 3);
		System.out.println("***************************");
		//问题二：
		test.sort(stus);
		//遍历输出
		test.print(stus);
	}	
}

class Students {
	int number;// 学号
	int state;// 年级
	int score;// 分数

	public String info() {
		return "学号：" + number + "，年级：" + state + "，分数：" + score;
	}
}

class Methon{
	/**
	 * 
	* @Description 遍历遍历Students[]数组的操作
	* @author CKong
	* @date 2019年9月14日上午10:51:22
	* @param stus 要查找的数组
	 */
	public void print(Students[] stus){
		for(int i = 0;i < stus.length;i++){
			System.out.println(stus[i].info());
		}
	}
	/**
	 * 
	* @Description 查找Stduents数组中指定年级的学生信息
	* @author CKong
	* @date 2019年9月14日上午10:51:49
	* @param stus 要查找的数组
	* @param state 要找的年级
	 */
	public void searchstate(Students[] stus,int state){
		for(int i = 0;i < stus.length;i++){
			if(stus[i].state == state)
				System.out.println(stus[i].info());
		}
	}
	/**
	 * 
	* @Description 给Students数组排序
	* @author CKong
	* @date 2019年9月14日上午10:52:31
	* @param stus 要查找的数组
	 */
	public void sort(Students[] stus){
		for(int i = 0;i < stus.length - 1;i++){
			for(int j = 0;j < stus.length - 1 - i;j++){
				if(stus[j].score > stus[j + 1].score){
					Students temp = stus[j];
					stus[j] = stus[j + 1];
					stus[j + 1] = temp;
				}
			}
		}
	}
}