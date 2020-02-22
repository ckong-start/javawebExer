package p1_1;

public class Project01 {
	FamilyAccount f = new FamilyAccount(10000);

	public static void main(String[] args) {
		Project01 p = new Project01();
		p.enterMenu();
	}

	public void enterMenu() {
		boolean loopFlag = true;
		while (loopFlag) {
			System.out.println("-----------------家庭收支记账软件-----------------");
			System.out.println();
			System.out.println("1 收支明细");
			System.out.println("2 登记收入");
			System.out.println("3 登记支出");
			System.out.println("4 退    出");
			System.out.print("请选择(1-4)：");
			char menuSelection = Utility.readMenuSelection();
			switch (menuSelection) {
			case '1':
				caidan1();
				break;
			case '2':
				caidan2();
				break;
			case '3':
				caidan3();
				break;
			case '4':// 退 出
				System.out.print("确认是否退出(Y/N)：");
				char confirmSelection = Utility.readConfirmSelection();
				if (confirmSelection == 'Y') {
					loopFlag = false;
					break;
				}
			}
		}
	}
	// 1 收支明细
	private void caidan1() {
		System.out.println("-----------------当前收支明细记录-----------------");
		System.out.println(f.details);
	}
	// 2 登记收入
	private void caidan2() {
		System.out.print("本次收入金额：");
		int readNumberIn = Utility.readNumber();
		f.balance += readNumberIn;
		System.out.print("本次收入说明：");
		String readStringIn = Utility.readString();
		f.details += "收入\t" + f.balance + "\t\t" + readNumberIn + "\t\t" + readStringIn + "\n";
		System.out.println("登记成功！");
	}
	// 3 登记支出
	private void caidan3() {
		System.out.print("本次支出金额：");
		int readNumberOut = Utility.readNumber();
		if (readNumberOut <= f.balance) {
			f.balance -= readNumberOut;
			System.out.print("本次支出说明：");
			String readStringOut = Utility.readString();
			f.details += "支出\t" + f.balance + "\t\t" + readNumberOut + "\t\t" + readStringOut + "\n";
			System.out.println("登记成功！");
		} else {
			System.out.println("余额不足\n登记失败！");
		}
	}

}

class FamilyAccount {
	int balance;
	String details = "收支\t账户金额\t\t收支金额\t\t说    明\n";

	public FamilyAccount(int balance) {
		this.balance = balance;
	}
}
