package exer;

public class PersonTest {
	public static void main(String[] args) {
		Person1 p1 = new Faculty();
		Person1 p2 = new Staff();
		if(p1 instanceof Faculty){
			Faculty p3 = (Faculty) p1;
			p3.degree = "本科";
			System.out.println(p3.degree);
		}
		if ( p2 instanceof Staff){
			Staff p4 = (Staff) p2;
			p4.duty = "职员";
			System.out.println(p4);
		}
	}
}
class Person{
	String name;
	String address;
	String telphone;
	String email;
}
class Employee extends Person1{
	String office;
	double wage;
	String hiredate;
}
class Faculty extends Employee{
	String degree;
	String level;
}
class Staff extends Employee{
	String duty;

	@Override
	public String toString() {
		return "Staff [duty=" + duty + "]";
	}
	
}