package exer1;

public class ExamStudent {

	private int flowID;
	private int type;
	private String IDCard;
	private String examCard;
	private String name;
	private String location;
	private int grade;
	public ExamStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamStudent(int flowID, int type, String iDCard, String examCard, String name, String location, int grade) {
		super();
		this.flowID = flowID;
		this.type = type;
		IDCard = iDCard;
		this.examCard = examCard;
		this.name = name;
		this.location = location;
		this.grade = grade;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getExamCard() {
		return examCard;
	}
	public void setExamCard(String examCard) {
		this.examCard = examCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getFlowID() {
		return flowID;
	}
	@Override
	public String toString() {
		System.out.println("======查询结果======");
		return getInfo();
	}
	private String getInfo() {
		return "流水号：" + flowID + "\r\n四级/六级：" + type + "\r\n身份证号：" + 
				IDCard + "\r\n准考证号：" + examCard + "\r\n学生姓名：" + name + "\r\n区域：" +
				location + "\r\n成绩：" + grade;
	}
	
}
