package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Numbers.Decimal;

/**
 * stores base 10 logarithms
 */
public class Log extends Function
{
    public Log()
    {
        setType("Function");
    }
    public Decimal evaluate(Decimal value)
    {
        return new Decimal(Math.log10(value.getValue()));
    }
    public String toString()
    {
        return "log(";
    }
}