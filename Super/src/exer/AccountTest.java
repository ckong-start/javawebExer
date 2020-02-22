package exer;

public class AccountTest {
	public static void main(String[] args) {
		Account acco = new Account(1122, 20000, 0.045);
		acco.withdraw(30000);
		System.out.println("您的账户余额为：" + acco.getBalance());
		acco.withdraw(2500);
		acco.deposit(3000);
		System.out.println("您的账户余额为：" + acco.getBalance());
		System.out.println("月利率为：" + acco.getMonthlyInterest());
	}
}
