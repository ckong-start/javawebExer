package Exer;

/*
 * 有一个农场公司，专门向市场销售各类水果，主要包括下列水果：葡萄　Grape，草莓　Stuawberry，苹果　Apple；
 * 有一个Fruit接口，包含grow生长，harvest收获和plant方法，葡萄、草莓和苹果都实现了这个接口；
 * 有一个农场园丁类FruitGardener，具有采摘水果的方法getFruit(String fruitName)；
 * 这时有人来果园玩，和园丁说介绍一下你的各种水果(创建一个People类进行测试，分别通过农场园丁类得到各种水果)。
 */
public class Test1 {
	public static void main(String[] args) {
		FruitGardener fg = new FruitGardener();
		Fruit f = fg.getFruit("Apple");
		f.plant();
	}
}

class FruitGardener {
	public Fruit getFruit(String fruitName) {
		if ("Grape".equals(fruitName))
			return new Grape();
		else if ("Stuawberry".equals(fruitName))
			return new Stuawberry();
		else if ("Apple".equals(fruitName))
			return new Apple();
		else
			return null;
	}
}

interface Fruit {
	void grow();

	void harvest();

	void plant();
}

class Grape implements Fruit {
	@Override
	public void grow() {
	}

	@Override
	public void harvest() {
	}

	@Override
	public void plant() {
	}
}

class Stuawberry implements Fruit {
	@Override
	public void grow() {
	}

	@Override
	public void harvest() {
	}

	@Override
	public void plant() {
	}
}

class Apple implements Fruit {
	@Override
	public void grow() {
	}

	@Override
	public void harvest() {
	}

	@Override
	public void plant() {
		System.out.println("苹果种植");
	}
}