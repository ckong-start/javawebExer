package listexer;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List coll = new ArrayList();
		coll.iterator();
		
	}
}



class Bank{//饿汉式
	private Bank(){}
	private static Bank instance = new Bank();
	public static Bank getInstance(){
		return instance;
	}
}
class Account{//懒汉式
	private Account(){}
	private static Account instance = null;
	public static synchronized Account getInstance(){
		if(instance == null){
			return new Account();
		}
		return instance;
	}
}