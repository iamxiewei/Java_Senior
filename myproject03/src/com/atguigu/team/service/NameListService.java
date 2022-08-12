package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

import static com.atguigu.team.service.Data.*;


public class NameListService {
		
	private Employee[] employees;
	
	
	//构造方法
	public NameListService()
	{
		employees=new Employee[EMPLOYEES.length];
		for(int i=0;i<employees.length;i++)
		{
			int type=Integer.parseInt(EMPLOYEES[i][0]);
			//获取Employee的4个基本信息
			int id=Integer.parseInt(EMPLOYEES[i][1]);
			String name=EMPLOYEES[i][2];
			int age=Integer.parseInt(EMPLOYEES[i][3]);
			double salary=Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type)
			{
			case EMPLOYEE:
				employees[i]=new Employee(id,name,age,salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i]=new Programmer(id,name,age,salary,equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i]=new Designer(id,name,age,salary,equipment,bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				stock=Integer.parseInt(EMPLOYEES[i][6]);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
				break;
			}
		}
		
		
	}
	
	//获取指定index上的员工的设备
	private Equipment createEquipment(int index) {
		// TODO Auto-generated method stub
		int type=Integer.parseInt(EQUIPMENTS[index][0]);
		String model=EQUIPMENTS[index][1];
		
		switch(type) {
		case PC:
			String display=EQUIPMENTS[index][2];
			return new PC(model,display);
		case NOTEBOOK:
			double price=Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(model,price);
			
		case PRINTER:
			String name=EQUIPMENTS[index][2];
			String type_printer=EQUIPMENTS[index][1];
			return new Printer(type_printer,name);
			
		}
		return null;
	}

	public Employee[] getAllEmployees()
	{
		return employees;
		
	}
	
	public Employee getEmployee(int id) throws TeamException
	{
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i].getId()==id)
			{
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
	
	
	
	
	
}
