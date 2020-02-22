package domain;

import service.Status;

public class Programmer extends Employee{
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	
	public Programmer(int id, String name, int age, int salary,Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	//"ID\t姓名\t年龄\t工资   + \t职位\t状态\t奖金\t股票\t领用设备"
	@Override
	public String toString() {
		return getDetail() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	//"TDI/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票"
	public String toTeamString(){
		return toTeamDetail() + "\t程序员\t";
	}
	public String toTeamDetail(){
		return memberId + "/" + getDetail();
	}
}
