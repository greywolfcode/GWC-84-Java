package MathObjects.Functions;

import java.util.Math;

import MathObjects.MathObject;
import MathObjects.Decimal;

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
        return Decimal(Math.log10(value.getValue()));
    }
    public String toString()
    {
        return "log(";
    }
}