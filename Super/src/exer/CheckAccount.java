package exer;

public class CheckAccount extends Account{
	private double overdraft;
	
	public CheckAccount(int id, double balance, double annualInterestRate, double overdraft){
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	public void withdraw(double amount){//取款
		if(getBalance() >= amount){
			//方式一：
//			setBalance(getBalance() - amount);
			//方式二：
			super.withdraw(amount);
		}else if(overdraft >= (amount - getBalance())){
			
				overdraft -= (amount - getBalance());
				//方式一：
				super.withdraw(getBalance());
				//方式二：
//				setBalance(0);
		}else{
			System.out.println("超过可透支的额度！" + '\n');
		}
	}
}
