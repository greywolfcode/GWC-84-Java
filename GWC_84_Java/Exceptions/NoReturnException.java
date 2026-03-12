package GWC_84_Java.Exceptions;

/**
 * Exception for when the return from data does not exist
 * or is of the wrong type
 */
public class NoReturnException extends Exception
{
    public NoReturnException(String message)
    {
        super(message);
    }
}