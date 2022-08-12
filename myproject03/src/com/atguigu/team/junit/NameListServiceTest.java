package com.atguigu.team.junit;

import org.junit.Test;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

public class NameListServiceTest {
	@Test
	public void testGetAllEmployees()
	{
		NameListService service= new NameListService();
		Employee[] employees=service.getAllEmployees();
		for(int i=0;i<employees.length;i++)
		{
			System.out.println(employees[i]);
		}
		
		
	}
	
	@Test
	public void testGetEmployee()
	{
		NameListService service= new NameListService();
		int id=1;
		id=101;
		Employee employee;
		try {
			employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
}
