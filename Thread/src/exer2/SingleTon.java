package exer2;

public class SingleTon {
	private static final SingleTon singleton = new SingleTon();
	private SingleTon(){}
	public static SingleTon getInstance(){
		return singleton;
	}
}

class SingleTon1{
	private static SingleTon1 singleton1 = null;
	private SingleTon1(){}
	public static SingleTon1 getInstance(){
		if(singleton1 == null){
			synchronized(SingleTon1.class){
				if(singleton1 == null)
					singleton1 = new SingleTon1();
			}
		}
		return singleton1;
	}
}
class SingleTon2{
	private static SingleTon2 singleton2 = null;
	private SingleTon2(){}
	public static synchronized SingleTon2 getInstance(){
		if(singleton2 == null){
			singleton2 = new SingleTon2();
		}
		return singleton2;
	}
}