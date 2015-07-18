package edu.gatech.seclass.gradescalculator;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyCourseTest {

    Students students = null;
    Grades grades = null;
    Course course = null;
    static final String GRADES_DB = "DB" + File.separator + "GradesDatabase6300-grades.xlsx";
    static final String GRADES_DB_GOLDEN = "DB" + File.separator + "GradesDatabase6300-grades-goldenversion.xlsx";
    static final String STUDENTS_DB = "DB" + File.separator + "GradesDatabase6300-students.xlsx";
    static final String STUDENTS_DB_GOLDEN = "DB" + File.separator + "GradesDatabase6300-students-goldenversion.xlsx";
    
    @Before
    public void setUp() throws Exception {    	
        FileSystem fs = FileSystems.getDefault();
        Path gradesdbfilegolden = fs.getPath(GRADES_DB_GOLDEN);
        Path gradesdbfile = fs.getPath(GRADES_DB);
        Files.copy(gradesdbfilegolden, gradesdbfile, REPLACE_EXISTING);
        Path studentsdbfilegolden = fs.getPath(STUDENTS_DB_GOLDEN);
        Path studentsdbfile = fs.getPath(STUDENTS_DB);
        Files.copy(studentsdbfilegolden, studentsdbfile, REPLACE_EXISTING);    	
    	students = new Students(STUDENTS_DB);
        grades = new Grades(GRADES_DB);
        course = new Course(students, grades);
    }

    @After
    public void tearDown() throws Exception {
        students = null;
        grades = null;
        course = null;
    }

        
    @Test
    public void testAddStudent() {
        Student student1 = new Student(97,"Bryan Smith","923432321","Team3");     
        course.addStudent(student1);
        course.updateStudents(new Students(STUDENTS_DB));       
        assertEquals(17, course.getNumStudents());
        Student student2 = new Student(98,"Gladey Anton","989092313","Team1");
        course.addStudent(student2);
        course.updateStudents(new Students(STUDENTS_DB));       
        assertEquals(18, course.getNumStudents());
    }

   
    @Test
    public void testAddNewTeamProject() {
        course.addNewTeamProject("Project: Project4");
        course.updateGrades(new Grades(GRADES_DB));
        assertEquals(4, course.getNumProjects());
        course.addNewTeamProject("Project: Project5");
        course.updateGrades(new Grades(GRADES_DB));
        assertEquals(5, course.getNumProjects());
    } 
    
   @Test
   public void testAddGradesForTeamProject() {
       String projectName1 = "Project 2";
       Student student1 = new Student("Josepha Jube", "901234502", course);
       Student student2 = new Student("Grier Nehling", "901234503", course);
       HashMap<Student, Integer> project1 = new HashMap<Student, Integer>();
       project1.put(student1, 95);
       project1.put(student2, 87);
       course.addGradesForTeamProject(projectName1, project1);
       course.updateGrades(new Grades(GRADES_DB));
       String projectName2 = "Project 3";
       HashMap<Student, Integer> project2 = new HashMap<Student, Integer>();
       project2.put(student1, 98);
       project2.put(student2, 100);
       course.addGradesForTeamProject(projectName2, project2);
       course.updateGrades(new Grades(GRADES_DB));       
       assertEquals(91, course.getAverageProjectsGrade(student1));
       assertEquals(78, course.getAverageProjectsGrade(student2));
   }    
}
    
