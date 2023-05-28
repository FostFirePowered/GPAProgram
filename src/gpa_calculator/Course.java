package gpa_calculator;

import GPACalcExceptions.CreditValueException;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private double numCredits;
    private LetterGrade letterGrade;

    private final List<GPAObserver> observerList;

    private double gpa;

    private String courseName;

    public Course(String courseName, LetterGrade letterGrade, int numCredits){
        this.courseName = courseName;
        this.letterGrade = letterGrade;

        observerList = new ArrayList<GPAObserver>();

        try{
            validateNumCredits(numCredits);
        }
        catch (CreditValueException exception){
            numCredits = 0;
        }
        finally{
            this.numCredits = numCredits;
            updateCourseGPA();
        }
    }

    public Course(LetterGrade letterGrade, int numCredits){
        this("", letterGrade, numCredits);
    }

    public void setNumCredits(int numCredits) throws CreditValueException {

        validateNumCredits(numCredits);

        this.numCredits = numCredits;

        updateCourseGPA();
    }


    private void validateNumCredits(int numCredits) throws CreditValueException {
        if (numCredits < 0){
            throw new CreditValueException("Illegal # of credits: " + numCredits + ". Ensure the value is greater than 0.");
        }
    }

    private void updateCourseGPA(){
        this.gpa =  (GradeConverter.getInstance().convertGrade(this.letterGrade) * getNumCredits() / getNumCredits());

    }

    public double getCourseGPA(){
        return gpa;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setLetterGrade(LetterGrade newLetterGrade){
        this.letterGrade = newLetterGrade;
        updateCourseGPA();
    }

    public LetterGrade getLetterGrade(){
        return this.letterGrade;
    }

    public double getNumCredits(){
        return numCredits;
    }

    public void addObserver(GPAObserver observer){
        observerList.add(observer);
        observer.updateGPA();
    }

    public void removeObserver(GPAObserver observerToRemove){
        observerList.remove(observerToRemove);
        observerToRemove.updateGPA();
    }

    public void notifyObservers(){
        for(GPAObserver observer : observerList){
            observer.updateGPA();
        }
    }


}
