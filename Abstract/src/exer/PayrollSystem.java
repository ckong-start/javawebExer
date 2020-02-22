package exer;

import java.util.Calendar;

/*
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
	public static void main(String[] args) {
		int month = Calendar.getInstance().get(Calendar.MONTH);
		Employee[] emps = new Employee[2];
		emps[0] = new SalariedEmployee("Jack", 10000, new MyDate(1991, 10, 1), 12000);
		emps[1] = new HourlyEmployee("John", 10001, new MyDate(1992,11, 1), 60.0, 240.0);
		for(int i = 0;i < emps.length;i++){
			System.out.print(emps[i]);
			double salary = emps[i].earnings();
			System.out.print("月工资为：" + salary);
			
			if((month+1) == emps[i].getBirthday().getMonth()){
				System.out.println(" 生日快乐！奖励100元");
			}
			
		}
	}
}
