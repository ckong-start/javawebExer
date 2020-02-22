package exer.json;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import exer.pojo.Person;

public class JsonTest {
	Gson gson = new Gson();
	
	@Test
	public void test1() throws Exception {
		Person p = new Person(1,"张三");
		//使用Gson工具类将JavaBean转换为String
		String pJsonString = gson.toJson(p);
		System.out.println(pJsonString);
		//将JsonString转换为JavaBean对象
		Person person = gson.fromJson(pJsonString, p.getClass());
		System.out.println(person);
	}
	
	@Test
	public void test2() throws Exception {
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person(1,"张三"));
		list.add(new Person(2,"李四"));
		list.add(new Person(3,"王五"));
		String listJsonString = gson.toJson(list);
		System.out.println(listJsonString);
		ArrayList<Person> list2 = gson.fromJson(listJsonString, new TypeToken<ArrayList<Person>>() {}.getType());
		System.out.println(list2);
		System.out.println(list2.get(2));
	}
	
	@Test
	public void test3() throws Exception {
		Map<String, Person> map = new HashMap<>();
		map.put("p1", new Person(1,"张三"));
		map.put("p2", new Person(2,"李四"));
		map.put("p3", new Person(3,"王五"));
		String mapJsonString = gson.toJson(map);
		System.out.println(mapJsonString);
		Map<String, Person> map2 = gson.fromJson(mapJsonString, new TypeToken<Map<String, Person>>(){}.getType());
		System.out.println(map2);
		System.out.println(map2.keySet());
		System.out.println(map2.values());
		System.out.println(map2.get("p3"));
	}
}
