package exer2;

public class InterfaceTest {
	public static void main(String[] args) {
		// 创建实现类（子类）对象
		Animal a = new Animal();
		// 调用实现后的方法
		a.eat();
		a.sleep();
		a.breathe();
		// 创建实现类（子类）对象
		Plant p = new Plant();
		p.eat();
		p.sleep();
		p.breathe();
		LiveAble.drink();
	}
}
