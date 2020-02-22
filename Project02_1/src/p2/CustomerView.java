package p2;

public class CustomerView {
	CustomerList customers = new CustomerList(10);

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}

	public void enterMainMenu() {
		boolean isFlag = true;
		do {
			System.out.println("-----------------客户信息管理软件-----------------\n");
			System.out.println("1 添 加 客 户");
			System.out.println("2 修 改 客 户");
			System.out.println("3 删 除 客 户");
			System.out.println("4 客 户 列 表");
			System.out.println("5 退           出\n");
			System.out.print("请选择(1-5)：");
			char menuSelection = CMUtility.readMenuSelection();
			switch (menuSelection) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.print("确认是否退出(Y/N)：");
				char confirmSelection = CMUtility.readConfirmSelection();
				if ('Y' == confirmSelection) {
					isFlag = false;
				}
				break;
			}
		} while (isFlag);
	}

	private void addNewCustomer() {
		System.out.println("---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(5);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(11);
		System.out.print("邮箱：");
		String email = CMUtility.readString(25);

		Customer cust = new Customer(name, gender, age, phone, email);
		boolean isSuccess = customers.addCustomer(cust);
		if (isSuccess)
			System.out.println("---------------------添加完成---------------------");
		else
			System.out.println("---------------------添加失败---------------------");
	}

	private void modifyCustomer() {
		System.out.println("---------------------修改客户---------------------");
		System.out.print("请选择待修改客户编号(-1退出)：");
		int num = CMUtility.readInt();
		if (num == -1)
			return;
		while (num > customers.getTotal() + 1 || num < -1) {
			System.out.print("输入有误，请重新输入：");
			num = CMUtility.readInt();
		}
		Customer[] cs = customers.getAllCustomers();
		int i = 0;
		for (; i < cs.length; i++) {
			if(cs[i].getId() == num)break;
		}

		Customer cust = customers.getCustomer(i);
		System.out.print("姓名(" + cust.getName() + "):");
		cust.setName(CMUtility.readString(5, cust.getName()));
		System.out.print("性别(" + cust.getGender() + "):");
		cust.setGender(CMUtility.readChar(cust.getGender()));
		System.out.print("年龄(" + cust.getAge() + "):");
		cust.setAge(CMUtility.readInt(cust.getAge()));
		System.out.print("电话(" + cust.getPhone() + "):");
		cust.setPhone(CMUtility.readString(11, cust.getPhone()));
		System.out.print("邮箱(" + cust.getEmail() + "):");
		cust.setEmail(CMUtility.readString(25, cust.getEmail()));

		boolean isSuccess = customers.replaceCustomer(i, cust);
		if (isSuccess)
			System.out.println("---------------------修改完成---------------------");
		else
			System.out.println("---------------------修改失败---------------------");
	}

	private void deleteCustomer() {
		System.out.println("---------------------删除客户---------------------");
		System.out.print("请选择待删除客户编号(-1退出)：");
		int num = CMUtility.readInt();
		if (num == -1)
			return;
		while (num > customers.getTotal() + 1 || num < -1) {
			System.out.print("输入有误，请重新输入：");
			num = CMUtility.readInt();
		}
		Customer[] cs = customers.getAllCustomers();
		int i = 0;
		for (; i < cs.length; i++) {
			if(cs[i].getId() == num)
			break;
		}
		System.out.print("确认是否删除(Y/N)：");
		char confirmSelection = CMUtility.readConfirmSelection();
		if (confirmSelection == 'N')
			return;
		boolean isSuccese = customers.deleteCustomer(i);
		if (isSuccese)
			System.out.println("---------------------删除完成---------------------");
		else
			System.out.println("---------------------删除失败---------------------");
	}

	private void listAllCustomers() {
		System.out.println("---------------------------客户列表---------------------------");
		System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
		Customer[] cust = customers.getAllCustomers();
		if(cust.length == 0)System.out.println("没有查询到客户信息。");
		else {
			for (int i = 0; i < cust.length; i++) {
				System.out.println(cust[i]);
			}
		}
		System.out.println("-------------------------客户列表完成-------------------------");
	}

}
