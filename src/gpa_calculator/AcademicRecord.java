package gpa_calculator;

import java.util.ArrayList;
import java.util.List;

public class AcademicRecord implements GPAObserver{

    private final List<Semester> semesterList;
    private double cumulativeGPA;


    public AcademicRecord(){
        semesterList = new ArrayList<Semester>();

    }

    public void addSemester(Semester semesterToAdd){
        semesterList.add(semesterToAdd);
        semesterToAdd.addObserver(this);
        semesterToAdd.notifyObservers();
    }

    public boolean removeSemester(Semester semesterToRemove){
        boolean removed = semesterList.remove(semesterToRemove);

        if(removed) {
            semesterToRemove.notifyObservers();
            semesterToRemove.removeObserver(this);


        }

        return removed;

    }


    public double getCumulativeGPA(){
        return cumulativeGPA;
    }

    public void ClearAcademicRecord(){

        while(semesterList.size() > 0){
            removeSemester(semesterList.get(0));
        }

    }

    @Override
    public void updateGPA() {
        double semesterGPASum = 0;

        for (Semester semester : semesterList){
            semesterGPASum += semester.getSemesterGPA();
        }

        //similarly to how it was before, we ensure there are no divisions by zero.
        cumulativeGPA = semesterList.size() == 0 ?  0 :  semesterGPASum / semesterList.size();


    }


}
