package exer;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	public Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getMonthlyInterest(){//获取月利率
		return annualInterestRate / 12;
	}
	public void withdraw(double amount){//取钱
		if(amount < 0 || amount > balance){
			System.out.println("余额不足！");
			return;
		}
		balance -= amount;
	}
	public void deposit(double amount){//存钱
		if(amount > 0 )
			balance += amount;
	}
}
