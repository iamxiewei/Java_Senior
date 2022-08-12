package com.atguigu.team.view;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;

public class TeamView {
	
	private NameListService listSvc=new NameListService();
	private TeamService teamSvc=new TeamService();
	
	public void enterMainMenu()
	{
		boolean loopFlag=true;
		char menu='0';
		listAllEmployees();
		while(loopFlag)
		{
		
			
			System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4））");
			menu=TSUtility.readMenuSelection();
			if(menu!='1')
				listAllEmployees();
			switch(menu)
			{
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
				System.out.println("确认是否退出(Y/N):");
				char isExit=TSUtility.readConfirmSelection();
				if(isExit=='Y')
				{
					loopFlag=false;
				}
				break;
			}
		}
	}
	
	
	//显示所有的员工信息
	private void listAllEmployees()
	{
		System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
		Employee[] employees=listSvc.getAllEmployees();
		if(employees==null||employees.length==0)
		{
			System.out.println("公司中没有任何员工信息！");
		}else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			
			for (Employee e : employees) {
				System.out.println(" " + e);
			}
			System.out.println("-------------------------------------------------------------------------------");
		}
		
	}
	
	
	
	private void getTeam()
	{
		System.out.println("\n--------------------团队成员列表---------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team.length == 0) {
			System.out.println("开发团队目前没有成员！");
		} else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
		}

		for (Programmer p : team) {
			System.out.println(" " + p.getDetailsForTeam());
		}
		System.out.println("-----------------------------------------------------");
	}
	
	
	private void addMember()
	{
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
		// 按回车键继续...
		TSUtility.readReturn();
	}
	
	private void deleteMember()
	{
		System.out.println("---------------------删除成员---------------------");
		System.out.print("请输入要删除员工的TID：");
		int id = TSUtility.readInt();
		System.out.print("确认是否删除(Y/N)：");
		char yn = TSUtility.readConfirmSelection();
		if (yn == 'N')
			return;
		try {
			teamSvc.removeMember(id);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}
		// 按回车键继续...
		TSUtility.readReturn();
	}
	
	public static void main(String[] args) {
		TeamView view=new TeamView();
		view.enterMainMenu();
	}
	
	
}
