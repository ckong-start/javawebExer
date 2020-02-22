package exer3;

public interface Swimming {
	public abstract void swim();
	public default void breathe(){
		System.out.println("大口呼吸");
	}
}
