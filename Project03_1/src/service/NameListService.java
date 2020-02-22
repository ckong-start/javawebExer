package service;

import static service.Data.*;

import java.util.ArrayList;

import domain.*;

public class NameListService {
	//根据项目提供的Data类构建相应大小的employees数组
	Employee[] ems = new Employee[Data.EMPLOYEES.length];
	
	/**
	 * 根据项目提供的Data类构建相应大小的employees数组再根据Data类中的数据构建不同的对象，
	 * 包括Employee、Programmer、Designer和Architect对象，
	 * 以及相关联的Equipment子类的对象将对象存于数组中
	 */
	public NameListService() {
		for (int i = 0; i < EMPLOYEES.length; i++) {
			/*int type = Integer.parseInt(EMPLOYEES[i][0]);*/
			String type = EMPLOYEES[i][0];
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			int salary = Integer.parseInt(EMPLOYEES[i][4]);
			int bonus;
			Equipment equipment;
			switch(type){
			case "10":
				ems[i] = new Employee(id, name, age, salary);
				break;
			case "11":
				equipment = getEquipment(i);
				ems[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case "12":
				equipment = getEquipment(i);
				bonus = Integer.parseInt(EMPLOYEES[i][5]);
				ems[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case "13":
				equipment = getEquipment(i);
				bonus = Integer.parseInt(EMPLOYEES[i][5]);
				int stock = Integer.parseInt(EMPLOYEES[i][6]);
				ems[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	
	/**
	 * 私有方法，获取对应员工的装备
	 * @param index
	 * @return	返回各个员工的装备
	 */
	private Equipment getEquipment(int index){
		int key = Integer.parseInt(EQUIPMENTS[index][0]);
		String model;
		
		switch(key){
		case PC:
			model = EQUIPMENTS[index][1];
			String display = EQUIPMENTS[index][2];
			return new PC(model, display);
		case NOTEBOOK:
			model = EQUIPMENTS[index][1];
			int price = Integer.parseInt(EQUIPMENTS[index][2]);
			return new NoteBook(model, price);
		case PRINTER:
			String name = EQUIPMENTS[index][1];
			String type = EQUIPMENTS[index][2];
			return new Printer(name, type);
		}
		return null;
	}
	
	/**
	 * 获取指定ID的员工对象。
	 * @param 指定员工的ID
	 * @return	指定员工对象
	 * @throws TeamException
	 */
	public Employee getEmployee(int id) throws TeamException{
		if(id <= 0 || id > ems.length)throw new TeamException("输入的id有误");
		return ems[id - 1];
	}
	
	/**
	 * 获取当前所有员工
	 */
	public void getAllEmployees() {
		for(Employee o : ems){
			System.out.println(o);
		}
	}
}
