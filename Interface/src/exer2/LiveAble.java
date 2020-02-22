package exer2;

public interface LiveAble {
	public abstract void eat();
	public abstract void breathe();
	public default void sleep(){
		System.out.println("静止不动");
	}
	public static void drink(){
		System.out.println("喝水");
	}
	
}
