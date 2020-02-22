package exer1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

import org.junit.Test;

import exer.Person;

public class TestGetConstructor {

	@Test
	public void test1() throws Exception{
		Class<?> clazz = Class.forName("exer.Person");
		Constructor<?> dc = clazz.getDeclaredConstructor(int.class);
		
	
		Object ni = dc.newInstance(18);
		Person p = (Person) ni;
		p.setName("Tom");
		System.out.println(p);
		p.setAge(20);
		System.out.println(p + "\r\n");
		dc.setAccessible(false);
		Constructor<?> dc1 = clazz.getConstructor(String.class,int.class);
		Person ni1 = (Person) dc1.newInstance("Jack",19);
		System.out.println(ni1);	
		
	}
	@Test
	public void test2() throws Exception{
		Class<?> clazz = Class.forName("exer.Person");
		Person obj = (Person) clazz.newInstance();
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(obj, "Tom");
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);
		age.set(obj, 20);
		System.out.println(obj);
		System.out.println(age.get(obj));
	}
	@Test
	public void test3() throws Exception{
		Class<?> clazz = Class.forName("exer.Person");
		Person o1 = (Person) clazz.newInstance();
		Person o2 = (Person) clazz.newInstance();
		Field name1 = clazz.getDeclaredField("name");
		Field age1 = clazz.getDeclaredField("age");
		age1.setAccessible(true);
		name1.setAccessible(true);
		name1.set(o1, "Tom");
		age1.set(o1, 18);
		Method m1 = clazz.getDeclaredMethod("toString");
		System.out.println(m1.invoke((Person)o1));
		System.out.println();
		Field name2 = clazz.getDeclaredField("name");
		Field age2 = clazz.getDeclaredField("age");
		name2.setAccessible(true);
		age2.setAccessible(true);
		name2.set(o2, "Jack");
		age2.set(o2, 20);
		System.out.println(m1.invoke(o2));
		Method m2 = clazz.getDeclaredMethod("setName", String.class);
		m2.invoke(o2, "Rose");
		Object invoke = m1.invoke(o2);
		System.out.println(invoke);
			
	}
	
	@Test
    public void test4(){//运行前，不能确定创建哪个类的对象。

        for(int i = 0;i < 100;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	 public Object getInstance(String classPath) throws Exception {
	       Class clazz =  Class.forName(classPath);
	       return clazz.newInstance();
	 }
	 
	 @Test
	 public void test() throws Exception{
		 Class<?> clazz = Class.forName("exer.Person");
		 /*Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, char.class);
		 constructor.setAccessible(true);
		 Person p = (Person) constructor.newInstance("Tom", 18, '男');*/
		 Method m1 = clazz.getDeclaredMethod("show");
		 m1.invoke(null);
		 Class<?> type = clazz.getDeclaredField("name").getType();
		 Method m = clazz.getDeclaredMethod("showNation",String.class);
		 Class[] parameterTypes = m.getParameterTypes();
		 for (Class class1 : parameterTypes) {
			System.out.println(class1.getName());
		}
	 }
}
