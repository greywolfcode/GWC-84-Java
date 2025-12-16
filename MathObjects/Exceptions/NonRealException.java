package MathObjects.Exceptions;

/**
 * Class for creating NonReal Excpetions to throw
 * 
 * Example use is with square root of a negative
 */
public class NonRealException extends RuntimeException
{
    public NonRealException(){}
    
    public NonRealException(String message)
    {
        super(message);
    }
}