package Exer;
/*
 * 有一个显示器接口Graphoscope，具有display方法，有两个类：台式显示器和液晶显示器都实现显示器接口，有一个显示器生产厂家能够生产这两种显示器；
 * 有Computer类，具有Graphoscope属性，生产两台电脑，分别配置台式显示器和液晶显示器。
 */
public class Test2 {
	public static void main(String[] args) {
		Computer c1 = new Computer();
		Computer c2 = new Computer();
		Factory f = new Factory();
		Graphoscope dis = f.getDisplay("LCD");
		c1.gra = dis;
		c2.gra = f.getDisplay("CRT");
		dis.display();
		f.getDisplay("CRT").display();
	}
}
interface Graphoscope{
	void display();
}
class  CRT implements Graphoscope{
	@Override
	public void display() {
		System.out.println("CRT显示器厚，但现实色彩鲜艳");
	}
}
class  LCD implements Graphoscope{
	@Override
	public void display() {
		System.out.println("LCD显示器薄");
	}
}
class Computer{
	Graphoscope gra;
	
	
}
class Factory{
	public Graphoscope getDisplay(String type){
		if("LCD".equals(type))
			return new LCD();
		else if("CRT".equals(type))
			return new CRT();
		else
			return null;
	}
}