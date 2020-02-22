package domain;

import service.Status;

public class Architect extends Designer{
	private int stock;

	public Architect(int id, String name, int age, int salary, Equipment equipment, int bonus,int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	//"ID\t姓名\t年龄\t工资   + \t职位\t状态\t奖金\t股票\t领用设备"
	@Override
	public String toString() {
		return getDetail() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock /*+ getEquipment().getDescription()*/;
	}
	public String toTeamString(){
		return toTeamDetail() + "\t架构师\t" + getBonus() + "\t" + stock;
	}
}
