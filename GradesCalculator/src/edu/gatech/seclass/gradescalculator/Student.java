package edu.gatech.seclass.gradescalculator;

public class Student {

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

}
    

