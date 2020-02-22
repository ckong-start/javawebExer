package service;
import domain.*;
import static service.Data.*;
/**
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 */
public class NameListService {
	private Employee[] employees;
	
	/**
	 * 给employees及数组元素进行初始化
	 */
	public NameListService() {
	/*
	 * 1.根据项目提供的Data类构建相应大小的employees数组
	 * 2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
	 * 3.将对象存于数组中
	 */
		employees = new Employee[EMPLOYEES.length];
		for (int i = 0; i < EMPLOYEES.length; i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			int salary = Integer.parseInt(EMPLOYEES[i][4]);
			
			Equipment eq;
			int bonus;
			int stock;
			switch(type){
			case EMPLOYEE://Employee: 10, id, name, age, salary
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER://Programmer: 11, id, name, age, salary, eq
				eq = getEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, Status.FREE, eq);
				break;
			case DESIGNER://Designer: 12, id, name, age, salary, eq, bonus
				eq = getEquipment(i);
				bonus = Integer.parseInt(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, Status.FREE, eq, bonus);
				break;
			case ARCHITECT://Architect: 13, id, name, age, salary, eq, bonus, stock
				eq = getEquipment(i);
				bonus = Integer.parseInt(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, Status.FREE, eq, bonus, stock);
				break;
			}
		}
	}
	private Equipment getEquipment(int index){
		int type = Integer.parseInt(EQIPMENTS[index][0]);
		switch(type){
		case PC://PC      :21, model, display
			return new PC(EQIPMENTS[index][1], EQIPMENTS[index][2]);
		case NOTEBOOK://NoteBook:22, model, price
			return new NoteBook(EQIPMENTS[index][1], Double.parseDouble(EQIPMENTS[index][2]));
		case PRINTER://Printer :23, type, name
			return new Printer(EQIPMENTS[index][1], EQIPMENTS[index][2]);
		}
		return null;
	}
	
	/**
	 * 获取当前所有员工。
	 * @return
	 */
	public Employee[] getAllEmployees(){
		return employees;
	}
	/**
	 * @Description 获取指定ID的员工对象。
	 * @param id
	 * @return
	 * @throws TeamException
	 */
	public Employee getEmployee(int id) throws TeamException{
		for(int i = 0;i < employees.length;i++){
			if(employees[i].getId() == id)return employees[i];
		}
		throw new TeamException("找不到指定的员工");
	}
	
}
