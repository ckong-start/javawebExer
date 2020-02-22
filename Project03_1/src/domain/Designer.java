package domain;

import service.Status;

public class Designer extends Programmer{
	private int bonus;

	public Designer(int id, String name, int age, int salary, Equipment equipment,int bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	//"ID\t姓名\t年龄\t工资   + \t职位\t状态\t奖金\t股票\t领用设备"
	@Override
	public String toString() {
		return getDetail() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String toTeamString(){
		return getTeamDetail() + "\t设计师\t" + getBonus();
	}
	
}
