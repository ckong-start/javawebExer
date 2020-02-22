package p2.ui;

import p2.bean.Customer;
import p2.service.CustomerList;
import p2.service.MyException;
import p2.util.CMUtility;

public class CustomerView {
	private CustomerList custList = new CustomerList();

	public static void main(String[] args) {
		// 创建主界面的对象
		CustomerView cv = new CustomerView();
		cv.enterMainMenu();
	}

	/*
	 * 用途：显示主菜单，响应用户输入， 根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理
	 */
	private void enterMainMenu() {
		boolean flag = true;
		while (flag) {
			System.out.println("---------------客户信息管理软件---------------");
			System.out.println();
			System.out.println("\t\t1.添加客户");
			System.out.println("\t\t2.删除客户");
			System.out.println("\t\t3.修改客户");
			System.out.println("\t\t4.查询客户");
			System.out.println("\t\t5.退        出");
			System.out.println();
			System.out.print("\t\t请选择(1-5)：");
			char key = CMUtility.readMenuSelection();
			switch (key) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				deleteCustomer();
				break;
			case '3':
				modifyCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("确认是否退出(Y/N)：");
				char readKey = CMUtility.readConfirmSelection();
				if (readKey == 'Y' || readKey == 'y') {
					flag = false;
				}
				break;
			}
		}

	}

	// 修改客户
	private void modifyCustomer() {
		// 拿到最终修改的索引，修改后的客户
		System.out.println("---------------------修改客户---------------------");
		System.out.println("请选择待修改客户编号(-1退出)：");
		int num = CMUtility.readInt();

		Customer c;
		try {
			c = custList.getCustomer(num);
			System.out.println("姓名(" + c.getName() + "):");
			c.setName(CMUtility.readString(4, c.getName()));
			System.out.println("性别(" + c.getGender() + "):");
			c.setGender(CMUtility.readChar(c.getGender()));
			System.out.println("年龄(" + c.getAge() + "):");
			c.setAge(CMUtility.readInt(c.getAge()));
			System.out.println("手机(" + c.getPhone() + "):");
			c.setPhone(CMUtility.readString(11, c.getPhone()));
			System.out.println("邮箱(" + c.getEmail() + "):");
			c.setEmail(CMUtility.readString(25, c.getEmail()));
			custList.replaceCustomer(num, c);
			System.out.println("---------------------修改完成---------------------");

		} catch (MyException e) {
			System.out.println(e.getMessage());
			System.out.println("---------------------修改失败---------------------");
		}

	}

	// 删除客户
	private void deleteCustomer() {
		// 拿到要删除的索引
		System.out.println("---------------------删除客户---------------------");
		System.out.println("请选择待删除客户编号(-1退出)：");
		int num = CMUtility.readInt();

		System.out.println("确认是否删除(Y/N)：");
		char key = CMUtility.readConfirmSelection();
		if (key == 'Y' || key == 'y') {

			try {
				custList.deleteCustomer(num);
				System.out.println("---------------------删除完成---------------------");
			} catch (MyException e) {
				System.out.println(e.getMessage());
				System.out.println("---------------------删除失败---------------------");
			}
		}
	}

	// 添加客户
	private void addNewCustomer() {
		System.out.println("---------------------添加客户---------------------");
		System.out.println("姓名：");
		String name = CMUtility.readString(4);
		System.out.println("性别：");
		char gender = CMUtility.readChar();
		System.out.println("年龄：");
		int age = CMUtility.readInt();
		System.out.println("手机：");
		String phone = CMUtility.readString(11);
		System.out.println("邮箱：");
		String email = CMUtility.readString(25);

		try {
			custList.addCustomer(new Customer(name, gender, age, phone, email));
			System.out.println("---------------------添加完成---------------------");
		} catch (MyException e) {
			System.out.println(e.getMessage());
			System.out.println("---------------------添加失败---------------------");
		}
	}

	// 获取所有的客户列表
	private void listAllCustomers() {
		// 获取所有的客户
		System.out.println("---------------------------客户列表---------------------------");
		System.out.println("编号\t姓名\t性别\t年龄\t手机\t\t邮箱");
		try {
			custList.getAllCustomers();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------客户列表完成-------------------------");
	}
}
