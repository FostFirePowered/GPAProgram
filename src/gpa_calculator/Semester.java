package gpa_calculator;

import java.util.ArrayList;
import java.util.List;

public class Semester implements GPAObserver {

    private final List<Course> courseList;

    private String semesterName;

    private final List <GPAObserver> GPAObservers;

    private double semesterGPA;
    public Semester(String semesterName){
        this.semesterName = semesterName;
        courseList = new ArrayList<Course>();
        GPAObservers = new ArrayList<GPAObserver>();
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
        toAdd.addObserver(this);
    }

    /**
     * Will remove all courses in the Semester. Mostly for testing and cleanup.
     */
    public void removeAllCourses(){
        while(courseList.size() > 0){
            removeCourse(courseList.get(0));
        }
    }

    public boolean removeCourse(Course toRemove){
        boolean removed = courseList.remove(toRemove);
        if(removed){
            toRemove.removeObserver(this);
            removeCourse(toRemove);
            notifyObservers();

        }
        return removed;

    }

    public double getSemesterGPA(){
        return semesterGPA;
    }

    @Override
    public void updateGPA() {
        double qualityPoints = 0;
        double hourSum = 0;

        for(Course course : this.courseList){
            double courseGPA = GradeConverter.getInstance().convertGrade(course.getLetterGrade());
            hourSum += course.getNumCredits();
            qualityPoints += courseGPA * course.getNumCredits();
        }

        //we avoid a division by 0 by using a ternary condition for semesterGPA.
        semesterGPA = hourSum == 0 ? 0 : qualityPoints / hourSum;



    }

    public void addObserver(GPAObserver observer){
        GPAObservers.add(observer);

    }

    public void removeObserver(GPAObserver observer){
        GPAObservers.remove(observer);

    }

    public void notifyObservers(){
        for(GPAObserver observer : GPAObservers){
            observer.updateGPA();
        }
    }
}
