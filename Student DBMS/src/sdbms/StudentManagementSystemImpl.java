package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem
{
	Scanner sc = new Scanner(System.in);
	Map<String, Student> db = new LinkedHashMap<String, Student>();
	
	@Override
	public void addStudent()
	{
		System.out.println("Enter Student Age:");
		int age = sc.nextInt();
		System.out.println("Enter Student Name:");
		String name = sc.next();
		System.out.println("Enter Student Marks:");
		double marks = sc.nextDouble();
		
		Student std =new Student(age, name, marks);
		db.put(std.getId(), std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is " +std.getId());
	}
	@Override
	public void displayStudent()
	{
		System.out.println("Enter Student id:");
		String id = sc.nextLine();
		id = id.toUpperCase();		//String sc = sc.next().toUpperCase();
		
		if(db.containsKey(id))
		{
			Student s = db.get(id);
			System.out.println("Id: " +s.getId());
			System.out.println("Age: " +s.getAge());
			System.out.println("Name: " +s.getName());
			System.out.println("Marks: " +s.getMarks());
		}
		else
		{
			try {					
				throw new StudentNotFoundException("Student with "+id +" is not found!");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudents()
	{
		System.out.println("Student details as follows:");
		System.out.println("---------------------------");
		Set<String> keys = db.keySet();
		for(String key : keys)
		{
			Student obj = db.get(key);
			System.out.println(obj); 	// System.out.println(de.get(key));
		}
	}
	@Override
	public void removeStudent()
	{
		System.out.println("Enter Student Id: ");
		String id = sc.next();
		id = id.toUpperCase();
		
		if(db.containsKey(id))
		{
			System.out.println("Enter Student Found!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Stuudent Rocerd deleted Successfully");
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student with " +id +" is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudents()
	{
		if(db.size() != 0)
		{
			System.out.println("Available Student Records: " +db.size());
			db.clear();
			System.out.println();
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("No Student records to deleted");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent()
	{
		System.out.println("Enter Student Id: ");
		String id = sc.next().toUpperCase();
		
		if(db.containsKey(id))
		{
			Student std = db.get(id);
			System.out.println("1: Update Age\n2: Update Name\n3: Update Marks");
			System.out.println("Enter Choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Age:");
				int age = sc.nextInt();
				std.setAge(age);
				System.out.println("Age Updated Successfully");
				break;
				
			case 2:
				System.out.println("Enter Name:");
				String name = sc.next();
				std.setName(name);
				System.out.println("Name Updated Successfully");
				break;
				
			case 3:
				System.out.println("Enter Age:");
				double marks = sc.nextInt();
				std.setMarks(marks);
				System.out.println("Age Updated Successfully");
				break;
				
			default:
				try {
					throw new InvalidChoiceException("Kindly Enter valid choice !");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
					
			}
		}
		
		else
		{
			try {
				throw new InvalidChoiceException("Student with" +id +" is not found !");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Override
	public void countStudent()
	{
		System.out.println("Total number of Student Records :" +db.size());
	}
	
	
	@Override
	public void sortStudents()
	{
		Set<String> keys = db.keySet();
		List<Student> li = new ArrayList<Student>();
		for(String key : keys)
		{
			Student s = db.get(key);
			li.add(s);
		}
		System.out.println("1: Sort by Id\n2: Sort by Age\n3: Sort by Name\n4: Sort by Marks\nEnter choice");
		System.out.println("Enter Choice:");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: 
			Collections.sort(li, new SortStudentById());
			display(li);
			break;
			
		case 2:
			Collections.sort(li, new SortStudentByAge());
			display(li);
			break;
			
		case 3:
			Collections.sort(li, new SortStudentByName());
			display(li);
			break;
			
		case 4:
			Collections.sort(li, new SortStudentByMarks());
			display(li);
			break;
			
		default:
			try {
				throw new InvalidChoiceException("Kindly Enter valid choice !");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	private static void display(List<Student> list)
	{
		for(Student s : list)
		{
			System.out.println(s);
		}
	}
	
	@Override
	public void getStudentwithHighestMarks()
	{
		Set<String> keys = db.keySet();
		List<Student> list = new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}
		
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with Highest Marks");
		System.out.println(list.get(list.size()-1));
		
	}
	
	@Override
	public void getStudentwithLowestMarks()
	{
		Set<String> keys = db.keySet();
		List<Student> list = new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}
		
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with lowest Marks");
		System.out.println(list.get(0));
	}
}
