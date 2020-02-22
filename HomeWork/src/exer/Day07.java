package exer;

public class Day07 {
	public static void main(String[] args) {
		Test10.printFuLi(10000, 20);
		/*Test9.isZhiJiao(4, 4, 5);
		Test8.printTemperature(30.0);
		Test7.round(10.1);
		Test7.round(10.4);
		Test7.round(10.5);
		Test7.round(10.9);
		Test5.getValue(10, 9, 5, "小");
		Test5.getValue(10, 23, 5, "大");
		Test4.showColor("red");
		Test4.showColor("blue");
		char char1 = Test3.getChar(100);
		System.out.println(char1);
		String string = Test3.getString(100);
		System.out.println(string);
		boolean doCheck = Test2.doCheck(2);
		System.out.println(doCheck);
		boolean doCheck1 = Test2.doCheck(3);
		System.out.println(doCheck1);
		Test1.printNum(10, 10);
		Test1.doubling(10, 10);*/
	}
	
}
class Test1{
	public static void printNum(int iVar, int iVar2) {
		System.out.println("iVar:" + iVar + ", iVar2:" + iVar2);
	}
	public static void doubling(int r, int p){
		System.out.println("翻倍：r=" + r * 2 + ",p=" + p * 2);
		printNum(r,p);
	}
	public static int doubling(int r){
		return r * 2;
	}
}
class Test2{
	public static boolean doCheck(int iVar){
		boolean flag;
		if(iVar % 2 == 0){
			for(int i = 0;i <= 20;i++){
				iVar -= i;
			}
			flag = true;
			System.out.println("num:" + iVar);
		}else{
			for(int i = 0;i <= 20;i++){
				iVar += i;
			}
			flag = false;
			System.out.println("num:" + iVar);
		}
		return flag;
	}
}
class Test3{
	public static char getChar(int i){
		return (char) i;
	}
	public static String getString(int i){
		char c = (char)i;
		return  "" + c + c + c + c;
	}
}
class Test4{
	public static void showColor(String str){
		switch(str){
		case "red":
			System.out.println(str + "是红色!");
			break;
		case "white":
			System.out.println(str + "是白色!");
			break;
		case "blue":
			System.out.println(str + "是蓝色!");
			break;
		case "black":
			System.out.println(str + "是黑色!");
			break;
		case "yellow":
			System.out.println(str + "是黄色!");
			break;
		case "green":
			System.out.println(str + "是绿色!");
			break;
		default:
			System.out.println("输入的颜色有误！");
		}
	}
}
class Test5{
	public static void getValue(int a, int b, int c, String str){
		if("大".equals(str)){
			int num = getMax(a,b,c);
			System.out.println("最" + str + "值为：" + num);
		}
		if("小".equals(str)){
			int num = getMin(a,b,c);
			System.out.println("最" + str + "值为：" + num);
		}
	}
	private static int getMax(int a, int b, int c){
		return a > b ? ((a > c) ? a : c) : ((b > c) ? b : c);
	}
	private static int getMin(int a, int b, int c){
		return a > b ? ((b > c) ? c : b) : ((a > c) ? c : a);
	}
}
class Test6{
	public static void printX(int num){
		
	}
}
class Test7{
	public static void round(double num){
		int i = (int)(num + 0.5);
		print(num,i);
	}
	private static void print(double num,int i){
		System.out.println(num + "->" + i);
	}
}
class Test8{
	public static void printTemperature(double d){
		double d1 = (9.0 / 5.0) * d + 32.0;
		System.out.println("摄氏度为：" + d + "°--华氏度为：" + d1 + "°");
	}
}
class Test9{
	public static void isZhiJiao(int a, int b, int c){
		if(a * a == b * b + c * c){
			System.out.println(a + ":" + b + ":" + c + 
					"是否可以组成直角三角形：true");
		}else if(b * b == a * a + c * c){
			System.out.println(b + ":" + a + ":" + c + 
					"是否可以组成直角三角形：true");
		}else if(c * c == a * a + b * b){
			System.out.println(c + ":" + a + ":" + b + 
					"是否可以组成直角三角形：true");
		}else{
			System.out.println(a + ":" + b + ":" + c + 
					"是否可以组成直角三角形：false");
		}
	}
}
class Test10{
	public static void printFuLi(int num,int year){
		int sum = (int) ((num * 1.0 * (Math.pow(1.1, year) - 1)) / 0.1);
		System.out.println("第1年末" + num + "\n第" + year + "年末" + sum);
	}
}