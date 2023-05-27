package gpa_calculator;

import java.util.ArrayList;
import java.util.List;

public class Semester {

    private final List<Course> courseList;

    private String semesterName;

    private double semesterGPA;
    public Semester(String semesterName){
        this.semesterName = semesterName;
        courseList = new ArrayList<Course>();
    }

    public Semester(){
        this("Unnamed Semester");
    }

    public void setSemesterName(String newSemesterName){
        this.semesterName = newSemesterName;
    }

    public String getSemesterName(){
        return this.semesterName;
    }

    public void addCourse(Course toAdd) {
        this.courseList.add(toAdd);
        updateSemesterGPA();
    }

    public boolean removeCourse(Course toRemove){
        boolean removed = courseList.remove(toRemove);
        if(removed){
            updateSemesterGPA();
        }

        return removed;

    }

    /*
    formula: multiply the gpa of a grade by number of credit hours.
    finally, divide by total number of credit hours.
     */
    private void updateSemesterGPA(){
        double qualityPoints = 0;
        double hourSum = 0;

        for(Course course : this.courseList){
            double courseGPA = GradeConverter.getInstance().convertGrade(course.getLetterGrade());
            hourSum += course.getNumCredits();
            qualityPoints += courseGPA * course.getNumCredits();
        }

        semesterGPA = qualityPoints / hourSum;



    }

    public double getSemesterGPA(){
        return semesterGPA;
    }

}
