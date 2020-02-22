package exer1;

public class Day12 {
	public static void main(String[] args) {
		Employee e1 = new Manager("张小强",9000.0,500.0);
		Employee e2 = new Clerk("李小亮",5000.0);
		Company com = new Company();
		System.out.println(e1.getName() + "的薪资为：" + e1.getWage() + "\t卡余额是：" + e1.getCard());
		System.out.println(e2.getName() + "的薪资为：" + e2.getWage() + "\t卡余额是：" + e2.getCard());
		for(int i = 1;i <= 12;i++){
			System.out.println("==========" + i + "月==========");
			com.salary(e1);
			com.salary(e2);
		}
	}
}
class Company implements Money{
	@Override
	public void salary(Employee e) {
		getSum(e);
		System.out.println(e.getName() + "的薪资为：" + e.getWage() + "\t卡余额是：" + e.getCard());
	}
	
	private void getSum(Employee e){
		e.setCard(e.getCard() + e.getWage());
		if(e instanceof Manager){
			e.setCard(e.getCard() + ((Manager) e).getBonus());
		}
		
	}
}
interface Money{
	void salary(Employee e);
}
class Clerk extends Employee{

	public Clerk() {
		super();
	}

	public Clerk(String name, double wage) {
		super(name, wage);
	}
	
}
class Manager extends Employee{
	private double bonus;
	public Manager() {
		super();
	}

	public Manager(String name, double wage,double bonus) {
		super(name, wage);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
}
abstract class Employee{
	private String name;
	private double wage;
	private double card;
/*	static private double sumM;
	static private double sumC;*/
	
	public Employee(String name, double wage) {
		super();
		this.name = name;
		this.wage = wage;
	}
	public Employee() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public double getCard() {
		/*if(this instanceof Manager){
			Manager m = (Manager)this;
			m.setCard(sumM);
			sumM += (m.getWage() + m.getBonus());
		}else if(this instanceof Clerk){
			Clerk c = (Clerk)this;
			c.setCard(sumC);
			sumC += c.getWage();
		}else {
			throw new RuntimeException("错误");
		}*/
		return card;
	}
	public void setCard(double card) {
		this.card = card;
	}
	
}