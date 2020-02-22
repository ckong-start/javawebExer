package exer1;

class Fu {
	boolean show(char a) {
		System.out.println(a);
		return true;
	}
}

public class Demo extends Fu {
	public static void main(String[] args) {
		int i = 0;
		Fu f = new Demo();
		Demo d = new Demo();
		for (f.show('A');f.show('B') && (i < 2); f.show('C')) {
			i++;
			d.show('D');
		}
	}

	boolean show(char a) {
		System.out.println(a);
		return false;
	}
}


