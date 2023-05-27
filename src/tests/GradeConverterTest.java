package tests;

import gpa_calculator.GradeConverter;
import gpa_calculator.LetterGrade;

import static org.junit.Assert.*;

public class GradeConverterTest {

    @org.junit.Test
    public void convertGrade() {

        float[] expectedVals = {4.0f, 3.7f, 3.3f, 3.0f, 2.7f, 2.3f, 2.0f,
                                1.7f, 1.3f, 1.0f, 0.0f};
        LetterGrade[] listOfValues = LetterGrade.values();

        GradeConverter converter = GradeConverter.getInstance();

        for(int i = 0; i < listOfValues.length; i++){
            assertEquals(converter.convertGrade(listOfValues[i]), expectedVals[i], 0.001);

        }




    }
}