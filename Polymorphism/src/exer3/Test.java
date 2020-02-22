package exer3;

public class Test {
	public static void main(String[] args) {
		Laptop lt = new Laptop();
		lt.run();
		Mouse m = new Mouse();
		lt.useUSB(m);
		KeyBoard kb = new KeyBoard();
		lt.useUSB(kb);
		lt.shutDown();
	}
}

class Laptop {
	public void run() {
		System.out.println("笔记本开机");
	}

	public void useUSB(USB usb) {
		if (usb != null) {
			usb.open();
			// 类型转换,调用特有方法
			if (usb instanceof Mouse) {
				Mouse m = (Mouse) usb;
				m.work();
			} else if (usb instanceof KeyBoard) {
				KeyBoard kb = (KeyBoard) usb;
				kb.work();
			}
			usb.close();
		}
	}
	public void shutDown(){
		System.out.println("笔记本关闭");
	}
}
interface USB{
	void open();
	void work();
	void close();
}
class Mouse implements USB{

	@Override
	public void open() {
		System.out.println("鼠标开启，红光闪一闪");
		
	}

	@Override
	public void work() {
		System.out.println("鼠标单击");
		
	}

	@Override
	public void close() {
		System.out.println("鼠标关闭，红光熄灭");
		
	}
	
}
class KeyBoard implements USB{

	@Override
	public void open() {
		System.out.println("键盘开启，绿光闪一闪");
		
	}

	@Override
	public void work() {
		System.out.println("键盘打字");
		
	}

	@Override
	public void close() {
		System.out.println("键盘关闭，绿光熄灭");
		
	}
	
}