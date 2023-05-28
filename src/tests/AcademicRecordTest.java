package tests;

import gpa_calculator.AcademicRecord;
import gpa_calculator.Course;
import gpa_calculator.LetterGrade;
import gpa_calculator.Semester;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcademicRecordTest {

    @Test
    public void addSemester() {
    }

    @Test
    public void removeSemester() {
    }

    @Test
    public void getCumulativeGPA() {
    }

    @Test
    public void testAcademicRecordCalculation(){
        Course courseOne = new Course(LetterGrade.B_PLUS, 3);
        Course courseTwo = new Course(LetterGrade.A_MINUS, 4);
        Course courseThree = new Course(LetterGrade.A, 3);
        Course courseFour = new Course(LetterGrade.C_PLUS, 3);

        Semester semesterOne = new Semester("Fall 2020");

        semesterOne.addCourse(courseOne);
        semesterOne.addCourse(courseTwo);
        semesterOne.addCourse(courseThree);
        semesterOne.addCourse(courseFour);

        AcademicRecord ar = new AcademicRecord();
        ar.addSemester(semesterOne);

        //we have done this test for a semester, but now we should do so with an academic record.
        assertEquals(3.35, ar.getCumulativeGPA(), 0.01);

        //then, we add another semester to the fold.

        Semester semesterTwo = new Semester("Spring 2021");
        semesterTwo.addCourse(new Course(LetterGrade.B, 4));
        semesterTwo.addCourse(new Course(LetterGrade.A, 3));
        semesterTwo.addCourse(new Course(LetterGrade.C, 3));
        semesterTwo.addCourse(new Course(LetterGrade.A_MINUS, 4));

        ar.addSemester(semesterTwo);

        assertEquals(3.27, ar.getCumulativeGPA(), 0.01);

        //now, see if clearing them all will result in 0.

        ar.ClearAcademicRecord();

        assertEquals(0, ar.getCumulativeGPA(), 0.0);
    }
}