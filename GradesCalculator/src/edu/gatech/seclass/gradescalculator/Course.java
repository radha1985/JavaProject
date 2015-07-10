package edu.gatech.seclass.gradescalculator;

import java.util.HashSet;

public class Course 
{   
	HashSet<Student> studentsRost = new HashSet<Student>();
	Students students;
	Grades   grades;
	
	public Course(Students students, Grades grades)
	{
		this.students = students;
		this.grades = grades;	
				
		for(int i=1;i<students.GetStudentInfo().size();i++)
		{
			String name = students.GetStudentInfo().get(i).get(0);
			String gtid = students.GetStudentInfo().get(i).get(1);
			String team = "";
			int attendance=0;	
			//System.out.println();		
			for(int j=1; j<students.GetTeams().size(); j++)
			{	
				//System.out.printf("\ni=%d\tj=%d\t", i,j);
				for(int k=1; k<students.GetTeams().get(j).size(); k++)
				{
					//System.out.printf("k=%d\t", k);
					if(students.GetTeams().get(j).get(k).equals(name))					
						team = students.GetTeams().get(j).get(0);
					
				}
			}
			//System.out.println();
			for(int j=1; j<grades.GetAttendance().size(); j++)
			{
				//System.out.printf("\ni=%d\tj=%d\t", i,j);
				for(int k=0; k<grades.GetAttendance().get(j).size(); k++)
				{	
					//System.out.printf("k=%d\t", k);
					if(grades.GetAttendance().get(j).get(k).equals(gtid))					
						attendance = Integer.parseInt(grades.GetAttendance().get(j).get(1));
						
				}
			}	
			Student student = new Student(attendance, name, gtid, team);
			studentsRost.add(student);
			
		}
	}
	public int getNumStudents()
	{
		return students.GetStudentInfo().size() -1;		
	}
	public int getNumAssignments()
	{
		if(grades.GetIndividualGrades().size() > 0)
			return grades.GetIndividualGrades().get(0).size()-1;
		else
			return 0;
	}

	public int getNumProjects()
	{
		if(grades.GetIndividualContribs().size() > 0)
			return grades.GetIndividualContribs().get(0).size()-1;
		else
			return 0;
	}	
	public HashSet<Student> getStudents()
	{
		return studentsRost;	
	}
	public Student getStudentByName(String studentName)
	{	
		for(Student student : studentsRost)
		{
			if (student.getName().equals(studentName))
				return student;
		}
		
		Student student = null;
		return student;
	}	
	public Student getStudentByID(String studentID)
	{
		for(Student student : studentsRost)
		{
			if (student.getGtid().equals(studentID))
				return student;
		}
		
		Student student = null;
		return student;
	}	
}
