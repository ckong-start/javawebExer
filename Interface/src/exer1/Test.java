package exer1;

public class Test {
	public static void main(String[] args) {
		new Platypus().respirations();
		new Platypus().run();
		new Heronsbill().reproduction();
		new Heronsbill().respirations();
		
	}
}
interface Biont{//生物
	public abstract void respirations();//呼吸
}
interface Animal extends Biont{//动物
	public abstract void run();
}
interface Plant extends Biont{//植物
	void reproduction();//繁殖
}
interface Vertebrate extends Animal{//脊椎动物
	
}
interface Mammal extends Vertebrate{//哺乳动物
	
}
interface Spermatophyte extends Plant{//种子植物
	
}
class Platypus implements Vertebrate{//鸭嘴兽

	@Override
	public void run() {
		System.out.println("鸭嘴兽只有两只脚，它可以用两只脚奔跑");
	}

	@Override
	public void respirations() {
		System.out.println("鸭嘴兽是动物，需要呼吸氧气");
	}
	
}
class Heronsbill implements Spermatophyte{//太阳花

	@Override
	public void reproduction() {
		System.out.println("太阳花可以用种子繁殖，也可以用枝条繁殖");
	}

	@Override
	public void respirations() {
		System.out.println("太阳花是植物，可以吸收二氧化碳，呼出氧气");
	}
	
}