package p2.ui;

import p2.bean.Customer;
import p2.service.CustomerList;
import p2.util.CMUtility;

public class CustomerView {
	// 创建最大包含10客户对象的CustomerList 对象，供以下各成员方法使用。
	private CustomerList list = new CustomerList(3);
	
	public static void main(String[] args) {
		// 创建主界面的对象
		CustomerView cv = new CustomerView();
		cv.enterMainMenu();
	}

	/*用途：显示主菜单，响应用户输入，
	根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理*/
	public void enterMainMenu() {
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
				flag = exit();
				break;
			}
		}
		
	}
	private boolean exit() {
		System.out.println("确认是否退出(Y/N)：");
		char key = CMUtility.readConfirmSelection();
		if (key == 'Y' || key == 'y') {
			return false;
		}
		
		return true;
	}

	// 修改客户
	private void modifyCustomer() {
		// 拿到最终修改的索引，修改后的客户
		System.out.println("---------------------修改客户---------------------");
		System.out.println("请选择待修改客户编号(-1退出)：");
		int num = CMUtility.readInt();
		// 判断num 是否是一个有效的客户编号
		if (num > 0) {
			// 通过编号查找客户的索引值
			int index = -1;
			// 获取所有客户的数组，
			Customer[] cs = list.getAllCustomers();
			for (int i = 0; i < cs.length; i++) {
				if (cs[i].getId() == num) {
					index = i;
					break;
				}
			}
			
			// 待修改的客户
			Customer c = list.getCustomer(index);
			
			if (c == null) {
				System.out.println("您查找的客户不存在，请查证后进行修改");
				System.out.println("---------------------修改失败---------------------");
				return;
			}
			
			System.out.println("姓名(" + c.getName() + "):");
			String name = CMUtility.readString(4, c.getName());
			System.out.println("性别(" + c.getGender() + "):");
			char gender = CMUtility.readChar(c.getGender());
			System.out.println("年龄(" + c.getAge() + "):");
			int age = CMUtility.readInt(c.getAge());
			System.out.println("手机(" + c.getPhone() + "):");
			String phone = CMUtility.readString(11, c.getPhone());
			System.out.println("邮箱(" + c.getEmail() + "):");
			String email = CMUtility.readString(25, c.getEmail());
			// 将新的客户信息封装到一个新的客户里面
			Customer cust = new Customer(name,gender,age,phone,email);
			// 将新客户的编号存入数组前变回原来编号
			// 拿到原来的客户编号
			int id = c.getId();
			// 将原来的客户编号存入新的封装的客户信息里面
			cust.setId(id);
			
			// 将原来的num进行-1
			Customer.setNum(Customer.getNum() - 1);
			
			boolean result = list.replaceCustomer(index, cust);
			
			if (result) {
				System.out.println("---------------------修改完成---------------------");
			} else {
				System.out.println("---------------------修改失败---------------------");
			}
		}
	}
	
	//删除客户
	private void deleteCustomer() {
		// 拿到要删除的索引
		System.out.println("---------------------删除客户---------------------");
		System.out.println("请选择待删除客户编号(-1退出)：");
		int num = CMUtility.readInt();
		if (num != -1 && num > 0) {
			System.out.println("确认是否删除(Y/N)：");
			char key = CMUtility.readConfirmSelection();
			if (key == 'Y' || key == 'y') {
				// 如果不等于-1且num不为负数，num其实就是客户的编号
				// 通过编号查找客户的索引值
				int index = -1;
				// 获取所有客户的数组，
				Customer[] cs = list.getAllCustomers();
				for (int i = 0; i < cs.length; i++) {
					if (cs[i].getId() == num) {
						index = i;
						break;
					}
				}
				
				boolean result = list.deleteCustomer(index);
				
				if (result) {
					System.out.println("---------------------删除完成---------------------");
				} else {
					System.out.println("---------------------删除失败---------------------");
				}
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
		
		Customer customer = new Customer(name,gender,age,phone,email);
		boolean result = list.addCustomer(customer);
		
		if (result) {
			System.out.println("---------------------添加完成---------------------");
		} else {
			System.out.println("---------------------添加失败---------------------");
		}
		
	}

	
	// 获取所有的客户列表
	private void listAllCustomers() {
		// 获取所有的客户
		Customer[] cs = list.getAllCustomers();
		
		if (cs.length == 0) {
			System.out.println("目前系统中没有客户，请及时添加客户，再进行查询");
		} else {
			System.out.println("---------------------------客户列表---------------------------");
			System.out.println("编号\t姓名\t性别\t年龄\t手机\t邮箱");
			for (int i = 0; i < cs.length; i++) {
				Customer c = cs[i];
				System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getGender() + "\t" + c.getAge() + "\t"
						+ c.getPhone() + "\t" + c.getEmail());
			}
			System.out.println("-------------------------客户列表完成-------------------------");
		}
	}
}
