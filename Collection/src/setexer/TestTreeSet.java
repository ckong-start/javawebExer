package setexer;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestTreeSet {
	public static void main(String[] args) {
		
		Comparator<Employee> com = new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				MyDate m1 = o1.getBirthday();
				MyDate m2 = o2.getBirthday();
				return m1.compareTo(m2);
			}
			
		};
		
		TreeSet set = new TreeSet(com);
		
		Employee e1 = new Employee("liudehua",23,new MyDate(1991,1,5));
		Employee e2 = new Employee("zhangxueyou",26,new MyDate(1993,4,23));
		Employee e3 = new Employee("liming",25,new MyDate(1997,8,10));
		Employee e4 = new Employee("guofucheng",22,new MyDate(1999,5,17));
		Employee e5 = new Employee("liangchengwei",29,new MyDate(1990,6,20));
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	@Test
	public void test(){
		Employee e1 = new Employee("liudehua",23,new MyDate(1990,1,5));
		Employee e2 = new Employee("zhangxueyou",26,new MyDate(1993,4,23));
		Employee e3 = new Employee("liming",25,new MyDate(1997,8,10));
		Employee e4 = new Employee("guofucheng",22,new MyDate(1999,5,17));
		Employee e5 = new Employee("liangchengwei",29,new MyDate(1990,6,20));
		
		TreeSet<Employee> ts = new TreeSet<Employee>();
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		ts.add(e4);
		ts.add(e5);
		
		for (Employee em : ts) {
			System.out.println(em);
		}
	}
	
	@Test
	public void test1(){
		Employee e1 = new Employee("liudehua",23,new MyDate(1990,6,20));
		Employee e2 = new Employee("zhangxueyou",26,new MyDate(1993,4,23));
		Employee e3 = new Employee("liming",25,new MyDate(1997,8,10));
		Employee e4 = new Employee("guofucheng",22,new MyDate(1999,5,17));
		Employee e5 = new Employee("liangchengwei",29,new MyDate(1990,6,20));
		
		TreeSet<Employee> ts = new TreeSet<Employee>(new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				int year = o1.getBirthday().getYear() - o2.getBirthday().getYear();
				int month = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
				int day = o1.getBirthday().getDay() - o2.getBirthday().getDay();
				
				if(year != 0){
					return year;
				}else if(month != 0){
					return month;
				}else if(day != 0){
					return day;
				}
				return o1.getName().length() - o2.getName().length();
			
			}
		});
		
		Collections.addAll(ts, e1, e2, e3, e4, e5);
		
		for (Employee em : ts) {
			System.out.println(em);
		}
	}
}
