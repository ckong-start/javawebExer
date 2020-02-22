package p2;

import java.util.Arrays;

public class CustomerList {
	private Customer[] customers;// 用来保存客户对象的数组
	private int total = 0;// 记录已保存客户对象的数量

	/*public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}*/

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public CustomerList() {
	}

	public CustomerList(int totalCustomer) {
		//初始化数组
		customers = new Customer[totalCustomer];
		customers[total++] = new Customer("张三",'男',23,"12311111111","zs@qq.com");
		customers[total++] = new Customer("李四",'男',21,"12322222222","ls@qq.com");
		customers[total++] = new Customer("王五",'男',25,"123788445678","ww@qq.com");
		customers[total++] = new Customer("杨六",'男',26,"123788445678","yl@qq.com");
		customers[total++] = new Customer("马七",'男',27,"123788445678","mq@qq.com");
		customers[total++] = new Customer("康八",'男',18,"123788445678","kb@qq.com");
		customers[total++] = new Customer("周九",'男',19,"123788445678","zj@qq.com");
		customers[total++] = new Customer("陈二",'男',20,"123788445678","ce@qq.com");
		customers[total++] = new Customer("孙一",'男',25,"123788445678","sy@qq.com");
	}

	public boolean addCustomer(Customer customer) {
		//数组满了，无法添加
		if (total >= customers.length)return false;
			
		//如果参数customer不是一个对象，添加失败
		if(customer == null)return false;
		
		customers[total++] = customer;
		return true;
	}

	public boolean replaceCustomer(int index, Customer cust) {
		if(index > total){
			return false;
		}
		customers[index] = cust;
		return true;
	}

	public boolean deleteCustomer(int index) {
		if(index > total || index < 0){
			return false;
		}
		for(int i = index;i < total;i++){
			customers[i] = customers[i + 1];
		}
		customers[total--] = null;
		return true;
	}

	public Customer[] getAllCustomers() {
		/*Customer[] cust = new Customer[total];
		for (int i = 0; i < cust.length; i++) {
			cust[i] = customers[i];
		}
		return cust;*/
		
		return Arrays.copyOf(customers, total);
	}

	public Customer getCustomer(int index) {
		return customers[index];
	}

}
