package p1;

import p1_1.Utility;

class ProjectTest {
	public static void main(String[] args) {
		boolean loopFlag = true;
		int balance = 10000;
		String details = "收支\t账户金额\t收支金额\t说    明\n";
		while (loopFlag) {
			System.out.println("-----------------家庭收支记账软件-----------------\n");
			System.out.println("                   1 收支明细");
			System.out.println("                   2 登记收入");
			System.out.println("                   3 登记支出");
			System.out.println("                   4 退  出");
			System.out.println("");
			System.out.print("                     请选择(1-4)：");

			char key = Utility.readMenuSelection();
			switch (key) {
			case '1':
				System.out.println("-----------------当前收支明细记录-----------------");
				System.out.println(details);
				System.out.println("");
				System.out.println("--------------------------------------------------\n");
				break;
			case '2':
				System.out.print("本次收入金额：");
				int moneyIn = Utility.readNumber();
				System.out.print("本次收入说明：");
				String infoIn = Utility.readString();
				balance += moneyIn;
				details += "收入\t" + balance + "\t\t" + moneyIn + "\t\t" + infoIn + "\n";
				System.out.println("---------------------登记完成---------------------\n");
				break;

			case '3':
				System.out.print("本次支出金额：");
				int moneyOut = Utility.readNumber();
				System.out.print("本次支出说明：");
				String infoOut = Utility.readString();
				if (balance >= moneyOut) {
					balance -= moneyOut;
					details += "支出\t" + balance + "\t\t" + moneyOut + "\t\t" + infoOut + "\n";
					System.out.println("---------------------登记完成---------------------\n");
				} else {
					System.out.println("余额不足。");
					System.out.println("---------------------登记失败---------------------\n");
				}
				break;

			case '4':
				System.out.print("确认是否退出(Y/N): ");
				char yn = Utility.readConfirmSelection();
				if (yn == 'Y')
					loopFlag = false;
				break;

			}
		}
	}
}
