package Dingus.Exceptions;

public class ExistingItemException extends Exception{
    public ExistingItemException(String errorMessage){
        super(errorMessage);
    }
}
