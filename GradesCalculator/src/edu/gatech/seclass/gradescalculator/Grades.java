package edu.gatech.seclass.gradescalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Grades {	
	
	String GradesDB = "";
	ArrayList<ArrayList<String>> Attendance = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> IndividualGrades = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> IndividualContribs = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> TeamGrades = new ArrayList<ArrayList<String>>();
	
	String formula;
	public Grades(String GradesDB)
	{
		this.GradesDB = GradesDB;

		try
		{
			FileInputStream file = new FileInputStream(new File(GradesDB));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet AttendanceSheet = workbook.getSheetAt(0);
			//Get First sheet from the workbook
			for (Row row : AttendanceSheet) 
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
				Attendance.add(ArrayRow);

			}
			//Gets Second sheet from the workbook
			XSSFSheet indigradessheet = workbook.getSheetAt(1);

			for (Row row : indigradessheet) 
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

				IndividualGrades.add(ArrayRow);

			}	
			//Gets Third sheet from the workbook
			XSSFSheet indicontribssheet = workbook.getSheetAt(2);

			for (Row row : indicontribssheet) 
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

				IndividualContribs.add(ArrayRow);

			}		
			//Get Fourth sheet from the workbook
			XSSFSheet teamgradessheet = workbook.getSheetAt(3);

			for (Row row : teamgradessheet) 
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

				TeamGrades.add(ArrayRow);

			}
			file.close();
			System.gc();
		}
		catch(Exception e)
		{

		}

	}
	public ArrayList<ArrayList<String>> GetAttendance()
	{
		return Attendance;
	}
	
	public ArrayList<ArrayList<String>> GetIndividualGrades()
	{
		return IndividualGrades;
	}
	
	public ArrayList<ArrayList<String>> GetIndividualContribs()
	{
		return IndividualContribs;
	}
	
	public ArrayList<ArrayList<String>> GetTeamGrades()
	{
		return TeamGrades;
	}	
		
	public void updateGradesDB(ArrayList<ArrayList<String>> NewGrades, ArrayList<ArrayList<String>> NewProjectGrades)
	{
		
		try 
		{
		    FileInputStream infile = new FileInputStream(new File("DB/GradesDatabase6300-grades.xlsx"));
		    
		    XSSFWorkbook workbook = new XSSFWorkbook(infile);
		    XSSFSheet sheet = workbook.getSheetAt(1);		    
		    
		    for (int i=0; i<NewGrades.size(); i++)
		    {
		    	for(int j=0;j<NewGrades.get(i).size();j++)
		    	{
		    		Cell cell = null;
		    		cell = sheet.getRow(i).getCell(j);

		    		if(cell == null)
		    		{
		    			sheet.getRow(i).createCell(j);
		    			cell = sheet.getRow(i).getCell(j);
		    		}

		    		cell.setCellValue(NewGrades.get(i).get(j));
		    	}
		    }
		    		    
		   XSSFSheet sheet2 = workbook.getSheetAt(2);

		    for (int i=0; i<NewProjectGrades.size(); i++)
		    {
		    	for(int j=0;j<NewProjectGrades.get(i).size();j++)
		    	{
		    		Cell cell = null;
		    		cell = sheet2.getRow(i).getCell(j);
		    		
		    		if(cell == null)
		    		{
		    			sheet2.getRow(i).createCell(j);
		    			cell=sheet2.getRow(i).getCell(j);
		    		}
		    		cell.setCellValue(NewProjectGrades.get(i).get(j));		    		
		    	}
		    }
		    infile.close();
		    FileOutputStream outFile1 = new FileOutputStream(new File(GradesDB));
		    workbook.write(outFile1);	    
		    outFile1.close();
		    System.gc();
		}
		
		 catch (FileNotFoundException e) {
			    e.printStackTrace();}
		 catch (IOException e) {
			    e.printStackTrace();}
	}
	public void setFormula(String formula) 
	{
		this.formula = formula;
	}
	public String getFormula()
	{
		return formula;
	}
}


			