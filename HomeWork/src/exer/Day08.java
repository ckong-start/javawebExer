package exer;

public class Day08 {
	public static void main(String[] args) {
		
		Cat c1 = new Cat(5, '黑');
		Cat c2 = new Cat(5, '白');
		c1.showMsg();
		c2.showMsg();
		System.out.println("属性相同？" + c1.isSame(c2));
		Cat c3 = new Cat(3, '黄');
		Cat c4 = new Cat(3, '黄');
		c3.showMsg();
		c4.showMsg();
		System.out.println("属性相同？" + c3.isSame(c4));
		/*Teacher t = new Teacher("周老师", 30, "Java面向对象");
		t.eat();
		t.teach();
		Manager m = new Manager("James", 9527, 15000, 3000);
		m.intro();
		m.showSalary();
		m.work();
		Coder c = new Coder("Kobe", "0025", 10000);
		c.intro();
		c.showSalary();
		c.work();
		Card c = new Card("黑桃",'A');
		c.showCard();
		MyDate m = new MyDate(1900,1,1);
		m.showDate();
		m.isBi();
		Circle c = new Circle(8);
		c.showArea();
		c.showPerimeter();*/
	}
}
//练习二
class Circle{
	private double r;
	public Circle(){
		
	}
	public Circle(double r){
		this.r = r;
	}
	public void setR(double r){
		this.r = r;
	}
	public double getR(){
		return r;
	}
	public void showArea(){
		System.out.println("半径为：" + (int)r + ",面积为：" + 3.14 * r * r);
	}
	public void showPerimeter(){
		System.out.println("半径为：" + (int)r + ",周长为：" + 2 * 3.14 * r);
	}
}

//练习三
class MyDate{
	private int year;
	private int month;
	private int day;
	public MyDate() {
	}
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void showDate(){
		System.out.println("日期：" + year + "年" + month + "月" + day + "日");
	}
	public void isBi(){
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			System.out.println(year + "年是闰年");
		}else{
			System.out.println(year + "年不是闰年");
		}
	}
}
//练习四
class Card{
	private String color;
	private char cardPoint;
	public Card(String color, char cardPoint) {
		this.color = color;
		this.cardPoint = cardPoint;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getCardPoint() {
		return cardPoint;
	}
	public void setCardPoint(char cardPoint) {
		this.cardPoint = cardPoint;
	}
	public void showCard(){
		System.out.println(color + cardPoint);
	}
}
//练习五
class Manager{
	private String name;
	private int number;
	private int salary;
	private int bonus;
	public Manager(String name, int number, int salary,int bonus) {
		super();
		this.name = name;
		this.number = number;
		this.salary = salary;
		this.bonus = bonus;
	}
	public Manager() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void intro(){
		System.out.println("经理姓名：" + name + "\n工号：" + number);
	}
	public void showSalary(){
		System.out.println("基本工资为" + salary + ",奖金为" + bonus);
	}
	public void work(){
		System.out.println("正在努力做着管理工作，分配任务，检查员工提交上来的代码...");
	}
}
class Coder{
	private String name;
	private String number;
	private int salary;
	public Coder() {
		super();
	}
	public Coder(String name, String number, int salary) {
		super();
		this.name = name;
		this.number = number;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void intro(){
		System.out.println("程序员姓名：" + name + "\n工号：" + number);
	}
	public void showSalary(){
		System.out.println("基本工资为" + salary + ",奖金为无");
	}
	public void work(){
		System.out.println("正在努力写代码...");
	}
}
//练习六
class Teacher{
	private String name;
	private int age;
	private String content;
	public Teacher(String name, int age, String content) {
		this.name = name;
		this.age = age;
		this.content = content;
	}
	public void eat(){
		System.out.println("年龄为" + age + "的" + name + "正在吃饭...");
	}
	public void teach(){
		System.out.println("年龄为" + age + "的" + name + "正在亢奋的讲着" + content + "的知识...");
	}
}
class Student{
	private String name;
	private int age;
	private String content;
	public Student(String name, int age, String content) {
		this.name = name;
		this.age = age;
		this.content = content;
	}
	public void eat(){
		System.out.println("年龄为" + age + "的" + name + "正在吃饭...");
	}
	public void teach(){
		System.out.println("年龄为" + age + "的" + name + "正在专心致志的听着" + content + "的知识...");
	}
}
//练习七
class Cat{
	private int age;
	private char color;
	public Cat() {
	}
	public Cat(int age, char color) {
		this.age = age;
		this.color = color;
	}
	public void showMsg(){
		System.out.println("猫的年龄：" + age + "，颜色：" + color);
	}
	public boolean isSame(Cat cat){
		if(this.age == cat.age && this.color == cat.color)return true;
		return false;
			
	}
}