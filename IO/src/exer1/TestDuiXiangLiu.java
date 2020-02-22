package exer1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class TestDuiXiangLiu {

	public static void main(String[] args) throws Exception {
		Student s1 = new Student("Tom",20);
		Student s2 = new Student("Jack", 21);
		Student s3 = new Student("Rose", 22);
		Student s4 = new Student("Green", 25);
		/*ArrayList<Student> list = new ArrayList<>();
		Collections.addAll(list, s1,s2,s3,s4);
		serializ(list);*/
		
		/*FileInputStream fis = new FileInputStream("hello.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Student> a = (ArrayList<Student>) ois.readObject();
		for (Student s : a) {
			System.out.println(s);
		}
		ois.close();
		fis.close();*/
		
		HashMap<Integer, Student> map = new HashMap<Integer,Student>();
		map.put(1000, s1);
		map.put(1001, s2);
		map.put(1002, s3);
		map.put(1003, s4);
//		serializ(map);
		
		FileInputStream fis = new FileInputStream("hello.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		HashMap<Integer,Student> hm = (HashMap<Integer,Student>) obj;
		Set<Integer> set = hm.keySet();
		for (Integer i : set) {
			Student s = hm.get(i);
			System.out.println(i + "--" + s);
		}
		
		
	}
	private static void serializ(ArrayList list) throws IOException{
		FileOutputStream fos = new FileOutputStream("hello.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.close();
		System.out.println("序列化完成");
	}
	private static void serializ(HashMap map) throws IOException{
		FileOutputStream fos = new FileOutputStream("hello.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(map);
		oos.close();
		System.out.println("序列化完成");
	}
}
class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -585186527257104843L;
	/**
	 * 
	 */
	private String name;
	private int age;
	
	public Student() {
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}