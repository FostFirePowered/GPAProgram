package GPACalcExceptions;

public class CreditValueException extends Exception{

    private String errorMessage;

    public CreditValueException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage(){

        return errorMessage;

    }

    @Override
    public String toString(){
        return "CreditValueException: " + getMessage();
    }


}
