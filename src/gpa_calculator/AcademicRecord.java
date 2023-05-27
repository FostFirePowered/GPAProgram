package gpa_calculator;

import java.util.ArrayList;
import java.util.List;

public class AcademicRecord {

    private List<Semester> semesterList;
    private double cumulativeGPA;


    public AcademicRecord(){

        semesterList = new ArrayList<Semester>();

    }

    private void updateCumulativeGPA(){
        //the simplest way to do this is to average out the cumulative gpas of each semester.

        double semesterGPASum = 0;

        for (Semester semester : semesterList){
            semesterGPASum += semester.getSemesterGPA();
        }

        cumulativeGPA = semesterGPASum / semesterList.size();


    }

    public void addSemester(Semester semesterToAdd){
        semesterList.add(semesterToAdd);
        updateCumulativeGPA();
    }

    public boolean removeSemester(Semester semesterToRemove){
        boolean removed = semesterList.remove(semesterToRemove);

        if(removed){
           updateCumulativeGPA();
        }

        return removed;
    }

    public double getCumulativeGPA(){
        return cumulativeGPA;
    }

}
