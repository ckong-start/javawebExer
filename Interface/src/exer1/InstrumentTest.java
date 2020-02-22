package exer1;

public class InstrumentTest {
	public static void main(String[] args) {
		Instrument i1 = new Piano();
		Instrument i2 = new Violin();
		i1.play();
		i2.play();
	}
}
interface Instrument{
	void play();
}
class Piano implements Instrument{

	@Override
	public void play() {
		System.out.println("钢琴演奏");
	}
	
}
class Violin implements Instrument{

	@Override
	public void play() {
		System.out.println("小提琴演奏");
	}
	
}