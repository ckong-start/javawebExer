package exer;

public class SeasonTest {
	public static void main(String[] args) {
		SeasonEnum[] values = SeasonEnum.values();
		for(int i = 0;i < values.length;i++){
			System.out.println(values[i]);
		}
	}
}
class Season{
	//声明为private final的属性
	private final String seasonName;
	private final String seasonDesc;
	
	//私有化类的构造器，保证不能在类的外部创建其对象，并在构造器中初始化属性
	private Season(String name,String desc){
		seasonName = name;
		seasonDesc = desc;
	}
	
	//在类的内部创建枚举类的实例。声明为：public static final
	public static final Season SPRING1 = new Season("春天","春暖花开");
	public static final Season SUMMER2 = new Season("夏天","夏日炎炎");
	public static final Season AUTUMN3 = new Season("秋天","秋高气爽");
	public static final Season WINTER4 = new Season("冬天","白雪皑皑");

	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
	
}