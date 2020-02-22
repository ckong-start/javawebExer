package exer;
/*
设计公司类（Lenovo）,有一个接口类Works,里面有接口work()，下面有2个部门（开发部和销售部）,
使用内部类分别实现开发部和销售部的工作。
 */

public class Lenovo{
	public void work(Works w){
		w.work();
	}
	class developmentDepartment implements Works{
		@Override
		public void work() {
			System.out.println("项目开发");
		}
	}
	class salesDepartment implements Works{
		@Override
		public void work() {
			System.out.println("销售产品");
		}
	}
	public static void main(String[] args) {
		Lenovo l1 = new Lenovo();
		l1.work(new Lenovo().new developmentDepartment());
		l1.work(new Lenovo().new salesDepartment());
	}
}
interface Works{
	public abstract void work();
}

