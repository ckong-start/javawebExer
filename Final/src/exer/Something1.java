package exer;



class Something {
	public int addOne(final int x) {
		return 4;
	}
}

public class Something1 {
	public static void main(String[] args) {
		Other o = new Other();
		new Something1().addOne(o);
	}

	public void addOne(final Other o) {
		o.i++;//o的reference没有改变，所以编译通过
	}
}

class Other {
	public int i;
}

class Something2 {
	int i;//此处i仅为instance variable，有默认值，为0

	public void doSomething() {
		System.out.println("i = " + i);
	}
}

class Something3 {
	final int i = 0;//此处i为final的instant variable（实例变量，或成员变量），没有默认值

	public void doSomething() {
		System.out.println("i = " + i);
	}
}
