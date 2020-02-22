package domain;

import service.Status;

public class Architect extends Designer{
	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Status status, Equipment equipment,
			double bonus, int stock) {
		super(id, name, age, salary, status, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	public String toString() {
		return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
	}
	
	// 1/2	马化腾	32	18000.0	架构师	15000.0	2000
	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t架构师\t" + getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
	}
}
