package MathObjects.Exceptions;

/**
 * Class for creating domain exceptions to throw
 * 
 * Example use is with arc sin outside range
 */
public class DomainException extends RuntimeException
{
    public DomainException(){}
    
    public DomainException (String message)
    {
        super(message);
    }
}