package StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Exer {

	public static void main(String[] args) {
		ArrayList<String> one = new ArrayList<String>();
		ArrayList<String> two = new ArrayList<String>();
		Collections.addAll(one, "迪丽热巴","宋远桥","苏星河","石破天","石中玉","老子","庄子","洪七公");
		Collections.addAll(two, "古力娜扎","张无忌","赵丽颖","张三丰","尼古拉斯","张天爱","张二狗");
		//1.第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
		Stream<String> s1 = one.stream()
			.filter(s->s.length() == 3)	
		//2.第一个队伍筛选之后只要前3个人；存储到一个新集合中。	
			.limit(3);
		//3.第二个队伍只要姓张的成员姓名；存储到一个新集合中。
		Stream<String> s2 = two.stream()
			.filter(s->s.startsWith("张"))
		//4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
			.skip(2);
		//5. 将两个队伍合并为一个队伍；存储到一个新集合中。
		Stream.concat(s1, s2)
		//6. 根据姓名创建 Person 对象；存储到一个新集合中。
			.map(name->new Person(name))
		//7. 打印整个队伍的Person对象信息。
			.forEach(t->System.out.println(t));
	}
}

class Person{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}