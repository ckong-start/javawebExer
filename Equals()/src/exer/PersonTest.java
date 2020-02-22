package exer;

public class PersonTest{
	public static void main(String[] args) {
		Person tangseng = new Person("唐僧", "人族");
		Person sunwukong = new Person("孙悟空", "仙族");
		Person baigujing = new Person("白骨精", "妖族");
		String s1 = tangseng.toString();
		System.out.println(s1);
		System.out.println(sunwukong.toString() + '\n' + baigujing.toString());
		sunwukong.skill(sunwukong.getName());
		baigujing.skill(baigujing.getName());
		System.out.println(tangseng.equals(sunwukong));
		System.out.println(tangseng.equals(tangseng));
		System.out.println(tangseng.equals(baigujing));
		System.out.println(sunwukong.equals(baigujing));
		System.out.println(sunwukong.equals(tangseng));
		System.out.println(baigujing.equals(tangseng));
		System.out.println(baigujing.equals(sunwukong));
		

	}
}
class Person{
	private String name;
	private double height;
	private String weapon;
	private String race;
	
	
	public Person() {
		super();
	}
	
	public Person(String name, String race) {
		super();
		this.name = name;
		this.race = race;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public void skill(String name){
		if(name.equals("孙悟空"))System.out.println("七十二变");
		if(name.equals("唐僧"))System.out.println("紧箍咒");
		if(name.equals("白骨精"))System.out.println("九阴白骨爪");
		
	}
	public String toString(){
		return "姓名： " + name + "；种族： " + race;
	}
	public boolean equals(Person p){
		if(this == p)
			return true;
		if(this.race.equals(p.race) || (this.race.equals("人族") && 
				p.race.equals("仙族")) || (this.race.equals("仙族") 
						&& p.race.equals("人族")))
			return true;
		return false;
	}
}
