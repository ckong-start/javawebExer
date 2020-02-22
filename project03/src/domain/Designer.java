package domain;

import service.Status;

public class Designer extends Programmer{
	private double bonus;

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Status status, Equipment equipment,
			double bonus) {
		super(id, name, age, salary, status, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public String toString() {
		return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}

	// 3/5	雷军	28	10000.0	设计师	5000.0
	public String getDetailsForTeam() {
		return  getTeamBaseDetails() + "\t设计师\t" + getBonus() + "\t" + getEquipment().getDescription();
	}
}
