package exer3;

public class Tortoise implements Runner,Swimming{

	@Override
	public void swim() {
		System.out.println("乌龟游的快");
	}

	@Override
	public void run() {
		System.out.println("乌龟跑的慢");
	}

	@Override
	public void breathe() {
		Swimming.super.breathe();
	}

}
