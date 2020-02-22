package service;

import static service.Data.*;

import java.util.ArrayList;

import domain.*;

public class NameListService {
	ArrayList<Employee> list = new ArrayList<Employee>();

	public NameListService() {
		for (int i = 0; i < EMPLOYEES.length; i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			int salary = Integer.parseInt(EMPLOYEES[i][4]);
			int bonus;
			Equipment equipment;
			switch(type){
			case EMPLOYEE:
				list.add(new Employee(id, name, age, salary));
				break;
			case PROGRAMMER:
				equipment = getEquipment(i);
				list.add(new Programmer(id, name, age, salary, equipment));
				break;
			case DESIGNER:
				equipment = getEquipment(i);
				bonus = Integer.parseInt(EMPLOYEES[i][5]);
				list.add(new Designer(id, name, age, salary, equipment, bonus));
				break;
			case ARCHITECT:
				equipment = getEquipment(i);
				bonus = Integer.parseInt(EMPLOYEES[i][5]);
				int stock = Integer.parseInt(EMPLOYEES[i][6]);
				list.add(new Architect(id, name, age, salary, equipment, bonus, stock));
				break;
			}
		}
	}
		
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
	public Employee getEmployee(int id) throws TeamException{
		if(id < 0 || id >= list.size())throw new TeamException("输入的id有误");
		return list.get(id);
	}

	public void getAllEmployees() {
		for(Object o : list){
			System.out.println(o);
		}
	}
}
