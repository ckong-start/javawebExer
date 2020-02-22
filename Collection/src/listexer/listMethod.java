package listexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/*1、添加元素
void add(int index, E ele)
boolean addAll(int index, Collection<? extends E> eles)
2、获取元素
E get(int index)
List subList(int fromIndex, int toIndex)
3、获取元素索引
int indexOf(Object obj)
int lastIndexOf(Object obj)
4、删除和替换元素
E remove(int index)
E set(int index, E ele)*/

public class listMethod {
	@Test
	public void test(){
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("ert");
		list.add("uio");
		list.add("bnm");
		System.out.println(list);
		Collection<String> coll = new ArrayList<String>();
		coll.add("fgh");
		coll.add("jkl");
		coll.add("iop");
		list.addAll(1,coll);
		System.out.println(list);
		String str = list.get(2);
		System.out.println(str);
		List<String> subList = list.subList(0, 5);
		System.out.println(subList);
		String remove = list.remove(7);
		System.out.println(remove);
		System.out.println(list);
		String set = list.set(4, "fgh");
		System.out.println(set);
		System.out.println(list);
	}
	
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("ert");
		list.add("uio");
		list.add("bnm");
		Collection<String> coll = new ArrayList<String>();
		coll.add("fgh");
		coll.add("jkl");
		coll.add("iop");
		list.addAll(coll);
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println("\n====================");
		for (String string : list) {
			System.out.print(string + " ");
		}
		System.out.println("\n===================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("\n===================");
		ListIterator<String> lit = list.listIterator();
		while(lit.hasNext()){
			System.out.print(lit.next() + " ");
		}
	}
}
