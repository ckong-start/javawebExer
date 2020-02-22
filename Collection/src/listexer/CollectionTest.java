package listexer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class CollectionTest {
	@Test
	public void test1(){
	Collection coll = new ArrayList();
	//add(Object e)增加对象
	coll.add(123);
	coll.add(456);
	coll.add(789);
	coll.add("adv");
	System.out.println(coll);
	//size()获取个数
	System.out.println(coll.size());
	
	//addAll(Collection coll1)
	Collection coll1 = Arrays.asList(456,789,002);
	coll.addAll(coll1);
	System.out.println(coll.size());
	}
	
	@Test
	public void test2(){
	Collection coll = new ArrayList();
	Collection coll1 = Arrays.asList(456,789,002);
	//clear()清除
//	coll1.clear();
	//isEmpty()是否为空
	System.out.println(coll1.isEmpty());
	
	//contains(Object obj)包含
	boolean contains = coll.contains(456);
	System.out.println(contains);
	
	//containsAll(Collection coll1)
	System.out.println(coll.containsAll(coll1));
	}
	
	@Test
	public void test3(){
	Collection coll = new ArrayList();
	Collection coll1 = Arrays.asList(456,789,002);
	//remove(Object obj)移除一个obj
	
	//removeAll(Collection coll1)移除coll1
	
	//retainAll(Collection coll1)求交集
	
	//equals(Object obj)要想返回true，需要当前集合和形参集合的元素都相同
	
	//hashcode()返回当前的哈希值
	int code = coll.hashCode();
	System.out.println(code);
	System.out.println("============");
	//集合-->数组:toArray()
	Object[] array = coll.toArray();
	for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	}
	System.out.println();
	//数组-->集合:asList()
	List list = Arrays.asList(new int[]{123,456});
	System.out.println(list.size());
	System.out.println(list);
	List list1 = Arrays.asList(new Integer[]{123,456});
	System.out.println(list1);
}
}
