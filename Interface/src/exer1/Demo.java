package exer1;

interface Playable {
	void play();
}
interface Bounceable{
	void play();
}
interface Rollable extends Playable,Bounceable{
	Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
	private String name;
	public String getName(){
		return name;
	}
	public Ball(String name) {
		this.name = name;
	}
	@Override
	public void play() {
		Ball ball = new Ball("Football");
		System.out.println(ball.getName());
	}
	
}

public class Demo {
	public static void main(String[] args) {

		
	}
}
