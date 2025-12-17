package MathObjects.Functions;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * Class for storing all absolute value functions
 */
public class Abs extends Function
{
    public Abs()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        return new Decimal(Math.abs(value.getValue()));
    }
    public String toString()
    {
        return "abs(";
    }
}