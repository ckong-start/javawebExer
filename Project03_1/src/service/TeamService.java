package service;

import java.util.Arrays;
import java.util.HashMap;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {
	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;
	
	public TeamService() {
		super();
	}
	/**
	 * 获取开发团队所有成员
	 */
	public void getTeam(){
		Programmer[] pro = Arrays.copyOf(team, total);
		/*Programmer[] pro = new Programmer[total];
		for (int i = 0; i < pro.length; i++) {
			pro[i] = team[i];
		}*/
		for(Programmer p : pro){
			System.out.println(p.toTeamString());
		}
	}
	/**
	 * 将员工添加到开发团队中
	 * @param e
	 * @throws TeamException
	 */
	public void addMember(Employee e) throws TeamException{
		if(!(e instanceof Programmer))throw new TeamException("该员工不是开发人员");
		if(total >= MAX_MEMBER)throw new TeamException("人员已满，无法添加");
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < total; i++) {//待优化
			if(team[i] instanceof Architect){
				putMap(map,"Arc");
			}else if(team[i] instanceof Designer){
				putMap(map,"Des");
			}else if(team[i] instanceof Programmer){
				putMap(map,"Pro");
			}
		}
		
		if(e instanceof Architect){
			if(map.get("Arc") != null && map.get("Arc") >= 1)
				throw new TeamException("该团队最多只能有一名架构师");
		}else if(e instanceof Designer){
			if(map.get("Des") != null && map.get("Des") >= 2)
				throw new TeamException("该团队最多只能有二名设计师");
		}else if(e instanceof Programmer){
			if(map.get("Pro") != null && map.get("Pro") >= 3)
				throw new TeamException("该团队最多只能有三名程序员");
		}
		
		//统计开发团队中的职位个数
		/*int numOfPro = 0, numOfDes = 0, numOfArc = 0;
		for (int i = 0; i < total; i++) {
			System.out.println(team[i].getClass());
			if(team[i] instanceof Architect){
				numOfArc++; 
			}else if(team[i] instanceof Designer){
				numOfDes++;
			}else if(team[i] instanceof Programmer){
				numOfPro++;
			}
		}
		
		//判断开发团队人员个数
		if(e instanceof Architect){
			if(numOfArc >= 1)throw new TeamException("该团队最多只能有一名架构师");
		}else if(e instanceof Designer){
			if(numOfDes >= 2)throw new TeamException("该团队最多只能有二名设计师");
		}else if(e instanceof Programmer){
			if(numOfPro >= 3)throw new TeamException("该团队最多只能有三名程序员");
		}*/
		
		//添加开发团队人员
		Programmer p = (Programmer) e;
		if(p.getStatus() == Status.BUSY)throw new TeamException("该员工已在开发团队");
		p.setMemberId(counter++);
		p.setStatus(Status.BUSY);
		team[total++] = p;
	}
	private void putMap(HashMap<String, Integer> map, String str){
		if(map.get(str) == null){
			map.put(str, 1);
		}else {
			map.put(str, map.get(str) + 1);
		}
	}
	/**
	 * 根据团队ID将成员从开发团队中删除
	 * @param memberId
	 * @throws TeamException
	 */
	public void removeMember(int memberId) throws TeamException{
		if(memberId < 0)throw new TeamException("输入的TID有误");
		int i = 0;
		for (; i < total; i++) {
			if(team[i].getMemberId() == memberId)break;
		}
		if(total == i)throw new TeamException("无法找到该员工");
		team[i].setStatus(Status.FREE);
		for (i += 1; i < total; i++) {
			team[i - 1] = team[i];
		}
		team[total--] = null;
	}
}
