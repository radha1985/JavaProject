package edu.gatech.seclass.gradescalculator;

import java.util.HashMap;
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
			System.out.println();		
			for(int j=1; j<students.GetTeams().size(); j++)
			{					
				for(int k=1; k<students.GetTeams().get(j).size(); k++)
				{				
					if(students.GetTeams().get(j).get(k).equals(name))					
						team = students.GetTeams().get(j).get(0);					
				}
			}
			
			for(int j=1; j<grades.GetAttendance().size(); j++)
			{			
				for(int k=0; k<grades.GetAttendance().get(j).size(); k++)
				{
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
		if(grades.GetTeamGrades().size() > 0)
			return grades.GetTeamGrades().get(0).size()-1;
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
	
	public void addAssignment(String assignmentName) 
	{		
		for(int i=0;i < grades.GetIndividualGrades().size(); i++)
		{			
			if (i == 0)
				grades.GetIndividualGrades().get(i).add(assignmentName);
			else
				grades.GetIndividualGrades().get(i).add("");
		}								
	}
		
	public void addGradesForAssignment(String assignmentName,HashMap<Student, Integer>grades2)
	{
		for (Student student : grades2.keySet()) 
		{
			int row = 0;
			int col = 0;
			for (int i =1; i<grades.GetIndividualGrades().size(); i++)
			{				
				if(grades.GetIndividualGrades().get(i).get(0).equals(student.getGtid()))									
					row = i;
				
			}	
			for (int j = 1; j< grades.GetIndividualGrades().get(0).size();j++)
			{				
				if(grades.GetIndividualGrades().get(0).get(j).equals(assignmentName))
					col = j;
				
			}
			if (row !=0 && col !=0)
				grades.GetIndividualGrades().get(row).set(col, grades2.get(student).toString());
		}				
	}
	
	public void updateGrades(Grades grades) 
	{		
		grades.updateGradesDB(this.grades.GetIndividualGrades(), this.grades.GetIndividualContribs());		
	}	
	
	public int getAverageAssignmentsGrade(Student student) 
	{
		int NoOfProjects = 0;
		double Total = 0;
		try{
		for (int i=1; i < grades.GetIndividualGrades().size(); i++)
		{	
			if(grades.GetIndividualGrades().get(i).get(0).equals(student.getGtid()))
			{
				for (int j = 1; j < grades.GetIndividualGrades().get(i).size(); j++)
				{									
					Total = Total + ((Integer.parseInt(grades.GetIndividualGrades().get(i).get(j))));					
					NoOfProjects++;					
				}
			}
		}		
		return ((int) Math.round((double)Total / (double)NoOfProjects));}
		catch(Exception e){return 0;}		
	}					
	
	public int getAverageProjectsGrade(Student student) 
	{		
		int NoOfProjects = 0;
		double Total = 0;
		
		for (int i=1; i < students.GetTeams().size(); i++)
		{	
			for(int j=1; j< students.GetTeams().get(i).size(); j++)
			{		
				if (students.GetTeams().get(i).get(j).equals(student.getName()))
					student.setTeam(students.GetTeams().get(i).get(0));				
			}			
		}
		
		try{
			for (int i=1; i < grades.GetIndividualContribs().size(); i++)
			{
				if(grades.GetIndividualContribs().get(i).get(0).equals(student.getGtid()))
				{	
					for (int j = 1; j < grades.GetIndividualContribs().get(i).size(); j++)
					{
						for (int k = 1; k<grades.GetTeamGrades().size();k++)
						{			
							for (int l = 1;l<grades.GetTeamGrades().get(k).size();l++)
							{						
								if(grades.GetTeamGrades().get(k).get(0).equals(student.getTeam()))
							    {
									Total = Total + ((Double.parseDouble(grades.GetIndividualContribs().get(i).get(j))) * ((Double.parseDouble(grades.GetTeamGrades().get(k).get(l))/100)));
									NoOfProjects++;
							    }
							}
						}
					}
				}
			}
			
			return ((int) Math.round((double)Total / (double)NoOfProjects));}
			catch(Exception e){return 0;}
	}
	
	public void addIndividualContributions(String projectName,
			HashMap<Student, Integer> contributions) 
	{
		for (Student student : contributions.keySet()) 
		{
			int row = 0;
			int col = 0;
			
			for (int i =1; i<grades.GetIndividualContribs().size(); i++)
			{				
				if(grades.GetIndividualContribs().get(i).get(0).equals(student.getGtid()))
					row = i;
				
			}	
			for (int j = 1; j< grades.GetIndividualContribs().get(0).size();j++)
			{				
				if(grades.GetIndividualContribs().get(0).get(j).equals(projectName))
					col = j;				
			}
			if (row !=0 && col !=0)
				grades.GetIndividualContribs().get(row).set(col, contributions.get(student).toString());
		}
		
	}

	public void addStudent(Student student1) {
		// TODO Auto-generated method stub
		
	}	
	public void updateStudents(Students students2) {
		// TODO Auto-generated method stub
		
	}
	
	public void addNewTeamProject(String string) {
		// TODO Auto-generated method stub
		
	}	
	
	public void addGradesForTeamProject(String projectName,
			HashMap<Student, Integer> grades2) {
		// TODO Auto-generated method stub
		
	}
			
}