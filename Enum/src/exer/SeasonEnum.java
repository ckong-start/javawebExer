package exer;

import org.junit.Test;

//使用enum定义的枚举类默认继承了java.lang.Enum类，因此不能再继承其他类
public enum SeasonEnum implements A{

	// 必须在枚举类的第一行声明枚举类对象
	// 枚举类的所有实例必须在枚举类中显式列出(，分隔 ；结尾)。
	// 列出的实例系统会自动添加public static final修饰
	SPRING("春天", "春暖花开"){
		public void eat(String something){
			System.out.println(getSEASONNAME() + "应该吃" + something);
		}
	}, 
	SUMMER("夏天", "夏日炎炎"){
		public void eat(String something){
			System.out.println(getSEASONNAME() + "应该吃" + something);
		}
	}, 
	AUTUMN("秋天", "秋高气爽"){
		public void eat(String something){
			System.out.println(getSEASONNAME() + "应该吃" + something);
		}
	}, 
	WINTER("冬天", "白雪皑皑"){
		public void eat(String something){
			System.out.println(getSEASONNAME() + "应该吃" + something);
		}
	};

	private final String SEASONNAME;// 季节的名称
	private final String SEASONDESC;// 季节的描述
	
	// 枚举类的构造器只能使用private权限修饰符
	private SeasonEnum(String seasonName, String seasonDesc) {
		this.SEASONNAME = seasonName;
		this.SEASONDESC = seasonDesc;
	}

	public String getSEASONNAME() {
		return SEASONNAME;
	}

	public String getSEASONDESC() {
		return SEASONDESC;
	}
	@Test
	public void test(){
		SeasonEnum spring = SeasonEnum.SPRING;
		spring.eat("火锅");
	}
}
