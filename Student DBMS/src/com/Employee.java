package com;

public class Employee
{
	String id;
	String name;
	
	static int count = 101;
	
	public Employee(String name)
	{
		this.id = "Emp"+count;
		this.name = name;
		count++;
	}

	public static void main(String[] args)
	{
		Employee e1 = new Employee("Tom");
		System.out.println("Id:"+e1.id +"  Name:"+e1.name);
		
		Employee e2 = new Employee("Tom");
		System.out.println("Id:"+e2.id +"  Name:"+e2.name);
		
		Employee e3 = new Employee("Tom");
		System.out.println("Id:"+e3.id +"  Name:"+e3.name);
	}

}
