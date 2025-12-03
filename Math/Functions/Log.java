package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Decimal;
import java.util.Math;

/**
 * stores base 10 logarithms
 */
public class Log extends Function
{
    public Log()
    {
        setType("Function")
    }
    public MathObject evaluate(MathObject Value)
    {
        return Decimal(Math.log10(value));
    }
    public String toString()
    {
        return "log(";
    }
}