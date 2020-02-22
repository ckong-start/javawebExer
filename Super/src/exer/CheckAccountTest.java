package exer;

public class CheckAccountTest {
	public static void main(String[] args) {
		CheckAccount ca = new CheckAccount(1122, 20000, 0.045, 5000);
		ca.withdraw(5000);
		System.out.println("您的账户余额：" + ca.getBalance() +'\n' + "您的可透支额：" + ca.getOverdraft() + '\n');
		ca.withdraw(18000);
		System.out.println("您的账户余额：" + ca.getBalance()+'\n' + "您的可透支额：" + ca.getOverdraft() + '\n');
		ca.withdraw(3000);
		System.out.println("您的账户余额：" + ca.getBalance()+'\n' + "您的可透支额：" + ca.getOverdraft() + '\n');
	}
}
