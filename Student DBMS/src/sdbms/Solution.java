package sdbms;

import java.util.Scanner;
import customexception.InvalidChoiceException;

public class Solution
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Student Management System");
		System.out.println("------------------------------------");
		Scanner  sc = new Scanner(System.in);
		
		StudentManagementSystem sms = new StudentManagementSystemImpl();
		
		while(true)
		{
			System.out.println("1:Add Student\n2:Dispaly Student\n3:Dispaly All Students\n4:Remove Student");
			System.out.println("5:Remove All Students\n6:Update Student\n7:Count Student");
			System.out.println("8:Sort Students\n9:Get Student with Highest Marks\n10:Get Student With Lowest Marks\n11:EXIT");
			System.out.println("Enter choice");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
				
			case 2:
				sms.displayStudent();
				break;
			
			case 3:
				sms.displayAllStudents();
				break;
			
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();
				
				break;
			
			case 6:
				sms.updateStudent();
				break;
			
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudents();
				break;
				
			case 9:
				sms.getStudentwithHighestMarks();
				break;
				
			case 10:
				sms.getStudentwithLowestMarks();
				break;
				
				
			case 11: 
				System.exit(0);
				
			default:
				try {					
					throw new InvalidChoiceException("Kindly Enter Valid Choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			System.out.println("---------------------");
		}
	}
}
