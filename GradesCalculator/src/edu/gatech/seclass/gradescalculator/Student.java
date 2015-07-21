package edu.gatech.seclass.gradescalculator;

public class Student {

	//private static final Students Students = null;
	//private static final Grades Grades = null;
	int   attendance;
	String name;
	String gtid;
	String team;
    
    public Student(int attendance,String name,String gtid,String team) 
    {
    	this.attendance = attendance;
    	this.name=name;
    	this.gtid=gtid;
    	this.team=team;
	}
    
	public Student(String name, String gtid, Course course) {
		this.name = name;
		this.gtid=gtid;
		course = new Course(course.students,course.grades);
		
	}

	public Student(String name, String gtid) {
		this.name = name;
		this.gtid=gtid;		
	}

	public String getName()
	{
		return(this.name);
	}
	
	public String getGtid()
	{
		return(this.gtid);
	}
	
	public int getAttendance()
	{
		return(this.attendance);
	}
	
	public String getTeam()
	{
		return(this.team);
	}	
	public void setTeam(String team)
	{
		this.team = team;
	}
	public void setid(String gtid)
	{
		this.gtid = gtid;
	}
	public void setAttendance(int attendance)
	{
		this.attendance = attendance;
	}
	public void setName(String name)
	{
		this.name = name;
	}	
	
}		