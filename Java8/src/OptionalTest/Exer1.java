package OptionalTest;

import java.util.Optional;

/*
 * （1）声明一个Girl类型，包含姓名（String）属性
 * （2）声明一个Boy类型，包含姓名（String），女朋友（Girl）属性
 * （3）在测试类中，创建一个Boy对象，并
 * 如果他有女朋友，显示他女朋友名称；
 * 如果他没有女朋友，他的女朋友默认为“嫦娥”，即只能欣赏“嫦娥”了
 */
public class Exer1 {

	public static void main(String[] args) {
		// Boy boy = new Boy("Tom",null);
		Boy boy = new Boy("Jack", new Girl("Rose"));
		Optional<Girl> girlFriend = Optional.ofNullable(boy.getGirlFriend());
		Optional.of(girlFriend.orElse(new Girl("嫦娥"))).ifPresent(s -> System.out.println(s));

	}
}

class Girl {
	private String name;

	public Girl(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + "]";
	}

}

class Boy {
	private String name;
	private Girl girlFriend;

	public Boy(String name, Girl girlFriend) {
		super();
		this.name = name;
		this.girlFriend = girlFriend;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Girl getGirlFriend() {
		return girlFriend;
	}

	public void setGirlFriend(Girl girlFriend) {
		this.girlFriend = girlFriend;
	}

	@Override
	public String toString() {
		return "Boy [name=" + name + ", girl=" + girlFriend.getName() + "]";
	}

}