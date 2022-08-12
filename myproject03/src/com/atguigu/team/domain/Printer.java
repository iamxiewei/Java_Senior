package com.atguigu.team.domain;

public class Printer implements Equipment{
	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	private String type;
	
	
	
	
	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return name+"("+type+")";
	}
	
}
