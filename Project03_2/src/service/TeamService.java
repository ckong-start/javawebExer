package service;

import java.util.ArrayList;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {
	private static int counter = 1;
	ArrayList<Employee> list = new ArrayList<Employee>();
	
	public TeamService() {
		super();
	}
	public Employee getTeamMember(int index) throws TeamException{
		int i = 0;
		for(;i < list.size();i++){
			Programmer p = (Programmer)list.get(i);
			if(p.getMemberId() == index){
				return list.get(i);
			}
		}
		throw new TeamException("未找到该员工");
	}

	public void getTeam() {
		if (list.size() == 0) {
			System.out.println("\t\t人员为空，请添加员工");
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof Programmer) {
					Programmer p = (Programmer) list.get(i);
					System.out.println(p.toTeamString());
				}
			}
		}
	}

	public void addMember(Employee e) throws TeamException{
		if (list.size() >= 5) {
			throw new TeamException("成员已满，无法添加");
		} else if (e instanceof Programmer == false) {
			throw new TeamException("该成员不是开发人员，无法添加");
		} else {
			Programmer p = (Programmer) e;
			if(p.getStatus() == Status.VOCATION)throw new TeamException("该员正在休假，无法添加");
			if(p.getStatus() == Status.BUSY)throw new TeamException("该员工已在本开发团队中");
			switch(inspect(p)){
			case 1:
				throw new TeamException("团队中至多只能有一名架构师");
			case 2:
				throw new TeamException("团队中至多只能有两名设计师");
			case 3:
				throw new TeamException("团队中至多只能有三名程序员");
			}
			p.setMemberId(counter++);
			p.setStatus(Status.BUSY);
			list.add(e);
		}
	}
	private int inspect(Programmer p){
		int sumArc = 0, sumDes = 0, sumPro = 0;
		for(int i = 0;i < list.size();i++){
			if(list.get(i) instanceof Architect)sumArc++;
			else if(list.get(i) instanceof Designer)sumDes++;
			else if(list.get(i) instanceof Programmer)sumPro++;
		}
		if(p instanceof Architect){
			if(sumArc >= 1)return 1;
		}else if(p instanceof Designer){
			if(sumDes >= 2)return 2;
		}else if(p instanceof Programmer){
			if(sumPro >= 3)return 3;
		}
		return 0;
	}
	
	public void removeMember(int memberId) throws TeamException{
		boolean isFlag = true;
		int i = 0;
		for(;i < list.size();i++){
			Programmer p = (Programmer)list.get(i);
			if(p.getMemberId() == memberId){
				p.setStatus(Status.FREE);
				isFlag = false;
				break;
			}
		}
		if(isFlag)throw new TeamException("未找到该员工,删除失败");
		list.remove(i);
	}
}
