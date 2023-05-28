package tests;

import gpa_calculator.Course;
import gpa_calculator.LetterGrade;
import gpa_calculator.Semester;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemesterTest {

    @Test
    public void setSemesterName() {
    }

    @Test
    public void getSemesterName() {
    }

    @Test
    public void addCourse() {
    }

    @Test
    public void removeCourse() {
    }

    @Test
    public void testProperGPAValue(){
        Course courseOne = new Course(LetterGrade.B_PLUS, 3);

        assertEquals(3.30f, courseOne.getCourseGPA(), 0.01);
        assertEquals(courseOne.getCourseName(), "");
    }
    @Test
    public void testSemesterGPAValue(){

        Course courseOne = new Course(LetterGrade.B_PLUS, 3);
        Course courseTwo = new Course(LetterGrade.A_MINUS, 4);
        Course courseThree = new Course(LetterGrade.A, 3);
        Course courseFour = new Course(LetterGrade.C_PLUS, 3);

        Semester semesterOne = new Semester("Fall 2020");

        semesterOne.addCourse(courseOne);
        semesterOne.addCourse(courseTwo);
        semesterOne.addCourse(courseThree);
        semesterOne.addCourse(courseFour);

        assertEquals(3.35, semesterOne.getSemesterGPA(),0.01);

        //then, test to make sure the GPA is 0 when we remove all of these semesters.

        semesterOne.removeAllCourses();

        assertEquals(0, semesterOne.getSemesterGPA(), 0);


    }

}