package gpa_calculator;

import java.util.Hashtable;

public class GradeConverter {

    private Hashtable<LetterGrade, Double> gradeTable;

    private GradeConverter(){
        initializeGradeTable();
    }


    //Note: this is a use of the IoDH idiom. I am unfamiliar with this idea,
    //but it is something IntelliJ has auto-corrected in response to a
    //double-lock lazy-initialized singleton.
    private static final class InstanceHolder {
        private static final GradeConverter instance = new GradeConverter();
    }

    public static GradeConverter getInstance(){
        return InstanceHolder.instance;
    }

    public double convertGrade(LetterGrade toConvert){
        return gradeTable.get(toConvert);
    }

    private void initializeGradeTable(){

        gradeTable = new Hashtable<LetterGrade, Double>();
        gradeTable.put(LetterGrade.A, 4.0);
        gradeTable.put(LetterGrade.A_MINUS, 3.7);
        gradeTable.put(LetterGrade.B_PLUS, 3.3);
        gradeTable.put(LetterGrade.B, 3.0);
        gradeTable.put(LetterGrade.B_MINUS, 2.7);
        gradeTable.put(LetterGrade.C_PLUS, 2.3);
        gradeTable.put(LetterGrade.C, 2.0);
        gradeTable.put(LetterGrade.C_MINUS, 1.7);
        gradeTable.put(LetterGrade.D_PLUS, 1.3);
        gradeTable.put(LetterGrade.D, 1.0);
        gradeTable.put(LetterGrade.F, 0.0);

    }




}
