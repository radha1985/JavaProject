package edu.gatech.seclass.gradescalculator;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Students 
{
	ArrayList<ArrayList<String>> StudentInfo = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> Teams = new ArrayList<ArrayList<String>>();
	
	
	public Students(String studentsDb) 
	{
		try 
    	{    	     
			FileInputStream file = new FileInputStream(new File(studentsDb));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet studentsheet = workbook.getSheetAt(0);
            
			//Iterate through each rows from students sheet
		    for (Row row : studentsheet) 
			{
			   ArrayList<String> ArrayRow = new ArrayList<String>();
			   for(Cell cell : row)
		       {
					String data="";
					
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
						data =  Integer.toString((int)(cell.getNumericCellValue()));
					else
						if(cell.getCellType() == Cell.CELL_TYPE_STRING)
							data = cell.getStringCellValue();

					ArrayRow.add(data);
				}
		       StudentInfo.add(ArrayRow);
			}
			//System.out.println(StudentInfo);	
			
		XSSFSheet teamsheet = workbook.getSheetAt(1);
		
		//Iterate through each rows from Team sheet
		for (Row row : teamsheet) 
		{
			ArrayList<String> ArrayRow = new ArrayList<String>();			
			for (Cell cell : row) 
			{				
				
				String data="";

				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
					data =  Integer.toString((int)(cell.getNumericCellValue()));
				else
					if(cell.getCellType() == Cell.CELL_TYPE_STRING)
						data = cell.getStringCellValue();			
				
				ArrayRow.add(data);
			}
			Teams.add(ArrayRow);
		}
		
		//System.out.println(Teams);
    	}
		catch(Exception e){}
		}
	public ArrayList<ArrayList<String>> GetStudentInfo()
	{	
		//System.out.println(StudentInfo);
		return StudentInfo;
		
	}
	public ArrayList<ArrayList<String>> GetTeams()
	{			
		return Teams;
	}
}