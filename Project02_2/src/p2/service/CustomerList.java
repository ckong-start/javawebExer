package p2.service;

import java.util.ArrayList;
import java.util.Iterator;

import p2.bean.Customer;

public class CustomerList {
	// 用来保存客户对象的数组
	private ArrayList<Customer> list = new ArrayList<Customer>();

	/*
	 * public CustomerList(int totalCustomer) 用途：构造器，用来初始化cs数组
	 * 参数：totalCustomer：指定customers数组的最大空间
	 */
	public CustomerList() {
		list.add(new Customer("张三", '男', 23, "12311111111", "zs@qq.com"));
		list.add(new Customer("李四", '男', 21, "12322222222", "ls@qq.com"));
		list.add(new Customer("李四", '男', 21, "12322222222", "ls@qq.com"));
		list.add(new Customer("王五", '男', 25, "123788445678", "ww@qq.com"));
		list.add(new Customer("杨六", '男', 26, "123788445678", "yl@qq.com"));
		list.add(new Customer("马七", '男', 27, "123788445678", "mq@qq.com"));
		list.add(new Customer("康八", '男', 18, "123788445678", "kb@qq.com"));
		list.add(new Customer("周九", '男', 19, "123788445678", "zj@qq.com"));
		list.add(new Customer("陈二", '男', 20, "123788445678", "ce@qq.com"));
		list.add(new Customer("孙一", '男', 25, "123788445678", "sy@qq.com"));
	}

	/*
	 * 用途：将参数customer添加组中最后一个客户对象记录之后 参数：customer指定要添加的客户对象
	 * 返回：添加成功返回true；false表示数组已满，无法添加
	 */
	public void addCustomer(Customer cust) throws MyException {
		// 如果参数customer不是一个对象，添加失败
		if (cust instanceof Customer) {
			list.add(cust);
		} else {
			throw new MyException("添加的对象有误");
		}
	}

	/*
	 * 用途：从数组中删除参数index指定索引位置的客户对象记录 参数： index指定所删除对象在数组中的索引位置
	 * 返回：删除成功返回true；false表示索引无效，无法删除
	 */
	public void deleteCustomer(int index) throws MyException {
		if (index < 0)throw new MyException("输入的索引有误");
		int i = 0;
		for(;i < list.size();i++){
			if(list.get(i).getId() == index){
				list.remove(i);
				return;
			}
		}
		throw new MyException("未找到该客户");
	}

	/*
	 * 用途：用参数customer替换数组中由index指定的对象 参数：customer指定替换的新客户对象 index指定所替换对象在数组中的位置
	 * 返回：替换成功返回true；false表示索引无效，无法替换
	 */
	public void replaceCustomer(int index, Customer cust) throws MyException {
		// 判断索引的有效性
		if (index < -1)throw new MyException("输入的索引有误");
		int i = 0;
		for(;i < list.size();i++){
			if(list.get(i).getId() == index){
				list.set(i, cust);
				return;
			}
		}
		throw new MyException("未找到该客户");
	}

	/*
	 * 用途：返回数组中记录的所有客户对象 返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
	 */
	public void getAllCustomers() throws MyException {

		if (list.size() == 0) {
			throw new MyException("目前系统中没有客户，请及时添加客户，再进行查询");
		}
		Iterator<Customer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	/*
	 * 用途：返回参数index指定索引位置的客户对象记录 参数： index指定所要获取的客户对象在数组中的索引位置
	 * 返回：封装了客户信息的Customer对象
	 */

	public Customer getCustomer(int index) throws MyException {
		// 判断索引的有效性
		if (index < -1)throw new MyException("输入的索引有误");
		int i = 0;
		for(;i < list.size();i++){
			if(list.get(i).getId() == index){
				if (list.get(i) == null)throw new MyException("您查找的客户不存在");
				return list.get(i);
			}
		}
		throw new MyException("未找到该客户");
	}

}
