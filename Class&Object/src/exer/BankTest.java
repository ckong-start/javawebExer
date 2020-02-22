package exer;

public class BankTest {
	public static void main(String[] args) {
		Customer cust = new Customer("jack", 1000, 1991234, "nanjing");
		Account acco = new Account(10012, 20000, cust);
		String s = acco.customer.say();
		System.out.println(s);
		System.out.println(acco.getInfo());
		boolean w1 = acco.withdraw(2000);
		if(w1)System.out.println("取钱成功! 余额为：" + acco.balance);
		else System.out.println("取钱失败！ 余额不足");
		boolean w2 = acco.save(4000);
		if(w2)System.out.println("存钱成功! 余额为：" + acco.balance);
		else System.out.println("存钱失败！ 存储金额有误");
		boolean w3 = acco.withdraw(22000);
		if(w3)System.out.println("取钱成功! 余额为：" + acco.balance);
		else System.out.println("取钱失败！ 余额不足");
		
	}
}
class Account{
	int cid;
	double balance;
	Customer customer;
	public Account(){
		
	}
	public Account(int cid,double balance,Customer customer){
		this.cid = cid;
		this.balance = balance;
		this.customer = customer;
	}
	public String getInfo(){
		return "cid is " + cid + ", balance is " + balance
				+ ", customer is " + customer.name;
	}
	public boolean withdraw(double num){//取钱
		if(balance >= num){
			balance -= num;
			return true;
		}
		return false;
	}
	public boolean save(double num){//存钱
		if(num >= 0){
			balance += num;
			return true;
		}
		return false;
	}
}
class Customer{
	String name;
	int id;
	int telphone;
	String address;
	
	public Customer() {
	}

	public Customer(String name, int id, int telphone, String address) {
		super();
		this.name = name;
		this.id = id;
		this.telphone = telphone;
		this.address = address;
	}

	public String say(){
		return "name is " + name + ",id is " + id + ",telphone is "
				+ telphone + ",address is " + address;
	}
}