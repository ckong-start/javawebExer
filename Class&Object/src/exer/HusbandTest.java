package exer;

public class HusbandTest {
	public static void main(String[] args) {
	Husband hus = new Husband();
	Wife wif = new Wife();
	hus.name = "jack";
	hus.age = 30;
	wif.name = "jane";
	wif.age = 28;
	hus.wife = wif;
	wif.husband = hus;
	hus.getInfo();
	wif.getInfo();
	}
}
class Husband{
	String name;
	int age;
	Wife wife;
	public void getInfo(){
		System.out.println("name is " + name + " , age is "
				+ age + " , wife is " + wife.name + " , "
						+ "wife's age is " + wife.age);
	}
}
class Wife{
	String name;
	int age;
	Husband husband;
	public void getInfo(){
		System.out.println("name is " + name + " , age is "
				+ age + " , husband is " + husband.name +
				" , husband's age is " + husband.age);
	}
}