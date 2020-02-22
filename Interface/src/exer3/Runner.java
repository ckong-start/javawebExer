package exer3;

public interface Runner {
	public abstract void run();
	public default void breathe(){
		System.out.println("大口呼吸");
	}
}
