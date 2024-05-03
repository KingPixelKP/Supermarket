package Dingus.Exceptions;

public class EmptyCartException extends Exception{
    public EmptyCartException(String errorMessage){
        super(errorMessage);
    }
}
