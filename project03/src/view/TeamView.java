package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu(){
		
		int key = 0;
		boolean loopFlag = true;
		while(loopFlag){
			if(key != 1){
				listAllEmployees();
			}
			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			key = TSUtility.readMenuSelection();
			System.out.println();
			switch (key) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N)：");
				char yn = TSUtility.readConfirmSelection();
				if (yn == 'Y')
					loopFlag = false;
				break;
			}
		}
	}
	private void listAllEmployees(){
		System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
		Employee[] allEmployees = listSvc.getAllEmployees();
		if(allEmployees.length == 0){
			System.out.println("没有客户记录！");
		}else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		}
		for(int i = 0;i < allEmployees.length;i++){
			System.out.println(allEmployees[i]);
		}
		System.out.println("-------------------------------------------------------------------------------");
	}
	private void getTeam(){
		System.out.println("\n--------------------团队成员列表---------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if(team.length == 0){
			System.out.println("开发团队目前没有成员！");
		}else{
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\t领用设备");
		}
		for(int i = 0;i < team.length;i++){
			System.out.println(team[i].getDetailsForTeam());
		}
		System.out.println("-----------------------------------------------------");
		TSUtility.readReturn();
	}
	private void addMember(){
		System.out.println("---------------------添加成员---------------------");
		System.out.print("请输入要添加的员工ID：");
		int id = TSUtility.readInt();
		
		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		TSUtility.readReturn();//回车继续
	}
	private void deleteMember(){
		System.out.println("---------------------删除成员---------------------");
		System.out.print("请输入要删除员工的TID：");
		int id = TSUtility.readInt();
		try {
			teamSvc.removeMember(id);
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		TSUtility.readReturn();//回车继续
	}
	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
	}
}
