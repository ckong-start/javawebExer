package mapexer;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest1 {
	public static void main(String[] args){
		TreeMap<User, Integer> map = new TreeMap<User, Integer>();
		User u1 = new User("Tom", 23);
		User u2 = new User("Jerry", 32);
		User u3 = new User("Jack", 20);
		User u4 = new User("Rose", 18);

		map.put(u1, 98);
		map.put(u2, 89);
		map.put(u3, 76);
		map.put(u4, 100);

		Set<Entry<User,Integer>> set = map.entrySet();
		Iterator<Entry<User, Integer>> iterator = set.iterator();
		while(iterator.hasNext()){
			Entry<User, Integer> entry = iterator.next();
			User key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "-" + value);
			
		}
	}
}

class User implements Comparable<User> {
	private String name;
	private int age;

	public User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(User user) {

		int compare = this.name.compareTo(user.name);
		if (compare != 0) {
			return compare;
		} else {
			return Integer.compare(this.age, user.age);
		}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}