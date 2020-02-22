package view;

import domain.*;
import service.*;

public class TeamView {
	NameListService listSvc = new NameListService();
	TeamService teamSvc = new TeamService();
	
	public static void main(String[] args) {
		TeamView teamView = new TeamView();
		teamView.enterView();
	}
	public void enterView(){
		boolean isFlag = true;
		char c;
		do{
			c = '0';
			if(c != '1'){
				System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
				System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
				listSvc.getAllEmployees();
				System.out.println("----------------------------------------------------------------------------------------------");
				System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)： ");
			}
			c = TSUtility.readMenuSelection();
			switch(c){
			case '1':
				listTeamMember();
				break;
			case '2':
				addTeamMember();
				break;
			case '3':
				deleteTeamMember();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N):");
				char selection = TSUtility.readConfirmSelection();
				if(selection == 'Y')isFlag = false;
				break;
			}
		}while(isFlag);
	}
	public void listTeamMember(){
		System.out.println("--------------------团队成员列表---------------------\n");
		System.out.println("TDI/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
		teamSvc.getTeam();
		System.out.println("-----------------------------------------------------");
		TSUtility.readReturn();
	}
	
	public void addTeamMember(){
		System.out.print("请输入要添加的员工ID：");
		int readInt = TSUtility.readInt();
		try {
			Employee em = listSvc.getEmployee(readInt - 1);
			teamSvc.addMember(em);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
		TSUtility.readReturn();
	}
	
	public void deleteTeamMember(){
		System.out.print("请输入要删除员工的TID：");
		int readInt = TSUtility.readInt();
		try {
			Employee teamMember = teamSvc.getTeamMember(readInt);
			System.out.print("确认是否删除(Y/N)(" + teamMember.getName() + ")：");
			char selection = TSUtility.readConfirmSelection();
			if(selection == 'Y'){
				try {
					teamSvc.removeMember(readInt);
					System.out.println("删除成功");
				} catch (TeamException e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("已取消删除");
			}
			TSUtility.readReturn();
		} catch (TeamException e1) {
			System.out.println(e1.getMessage());
			TSUtility.readReturn();
		}
	}
}
