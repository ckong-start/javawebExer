package p2.service;

import java.util.Arrays;

import p2.bean.Customer;

public class CustomerList {
	// 用来保存客户对象的数组
	private Customer[] cs;
	// 用来记录客户的真实数量
	private int total = 0;
	
	/*public CustomerList(int totalCustomer) 
	用途：构造器，用来初始化cs数组
	参数：totalCustomer：指定customers数组的最大空间*/
	public CustomerList(int totalCustomer) {
		cs = new Customer[totalCustomer];
	}
	
	
	/*用途：将参数customer添加组中最后一个客户对象记录之后
	参数：customer指定要添加的客户对象 
	返回：添加成功返回true；false表示数组已满，无法添加*/
	public boolean addCustomer(Customer customer) {
		//	如果数组满了，无法添加
		if (cs.length <= total) {
			return false;
		}
		
		// 如果参数customer不是一个对象，添加失败
		if (customer == null) {
			return false;
		}
		
		// 添加到数组中哪个位置呢？	
		/* [null,null,null,null,null]	total = 0    新客户添加到索引0
		 * [客户1,null,null,null,null]   total = 1    新客户添加到索引1
		 * [客户1,客户2,null,null,null]    total = 2    新客户添加到索引2
		 * [客户1,客户2,客户3,null,null]    total = 3    新客户添加到索引3
		 * [客户1,客户2,客户3,客户4,null]    total = 4    新客户添加到索引4
		 */
		// 将新客户添加到索引值为total这个位置上
		//cs[total] = customer;
		// 因为数组中新添加了一位客户，total还要进行累加
		// total++;
		cs[total++] = customer;
		
		return true;
	}
	
	
	/*用途：从数组中删除参数index指定索引位置的客户对象记录
	参数： index指定所删除对象在数组中的索引位置
	返回：删除成功返回true；false表示索引无效，无法删除*/
	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}
		
		/* 
		 * [客户1,客户2,客户3,客户4,null]    total = 4  
		 * 
		 * 如果删除客户2    删除索引1
		 * [客户1,客户2,客户3,客户4,null]
		 * 第一次操作	[客户1,客户3,客户3,客户4,null]	将索引2处的值赋值给索引1处
		 * 		数组[1] = 数组[2]
		 * 第二次操作	[客户1,客户3,客户4,客户4,null]    将索引3处的值赋值给索引2处
		 * 		数组[2] = 数组[3]
		 * 
		 * total真实的客户的人数
		 * 
		 * 假如数组客户已经满，total 为   5		数组的长度也为5
		 * 
		 * 第三次操作	[客户1,客户3,客户4,null,null]    将索引3处的值赋值为null
		 * 		数组[3] = null
		 * 
		 * [客户1,客户3,客户4,null,null]
		 */
		
		
		for (int i = index ; i < total -1; i++) {
			cs[i] = cs[i+1];
		}
		
		
		
		cs[total-1] = null;
		// cs[--total] = null
		
		// 因为已经成功删除一个客户，真实客户数量变量-1
		total--;
		
		return true;
	}
	
	
	
	/*用途：用参数customer替换数组中由index指定的对象
	参数：customer指定替换的新客户对象 
		 index指定所替换对象在数组中的位置
	返回：替换成功返回true；false表示索引无效，无法替换*/
	public boolean replaceCustomer(int index, Customer cust) {
		// 判断索引的有效性
		if (index < 0 || index >= total) {
			return false;
		}
		
		cs[index] = cust;
		return true;
	}
	
	
	
	/*用途：返回数组中记录的所有客户对象
	返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。*/
	public Customer[] getAllCustomers() {
		// 创建一个total长度的数组
	/*	Customer[] newArr = new Customer[total];
		
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = cs[i];
		}
		
		return newArr;*/
		return Arrays.copyOf(cs, total);
		
	}
	
	/*用途：返回参数index指定索引位置的客户对象记录
	参数： index指定所要获取的客户对象在数组中的索引位置
	返回：封装了客户信息的Customer对象*/
	
	public Customer getCustomer(int index) {
		// 判断索引的有效性
		if (index < 0 || index >= total) {
			return null;
		}
		
		return cs[index];
	}


}

