package exer;

public class GenericDemo1 {
	public static void main(String[] args) {
		MyGenericClass<String> my1 = new MyGenericClass<String>();
		my1.setMvp("大胡子噔噔");
		String mvp = my1.getMvp();
		System.out.println(mvp);
		MyGenericClass<Integer> my2 = new MyGenericClass<Integer>();
		my2.setMvp(1234);
		Integer mvp2 = my2.getMvp();
		System.out.println(mvp2);
	}
}

class MyGenericClass<MVP>{
	private MVP mvp;

	public MVP getMvp() {
		return mvp;
	}

	public void setMvp(MVP mvp) {
		this.mvp = mvp;
	}
	
}
