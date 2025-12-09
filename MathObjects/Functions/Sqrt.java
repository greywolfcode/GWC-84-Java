package MathObjects.Functions;

import MathObjects.Numbers.Decimal;

/**
 * Class for storing all square root functions
 */
public class Sqrt extends Function
{
    public Sqrt()
    {
        setType("Function");
    }
    public Decimal evaluate(Decimal value)
    {
        return new Decimal(Math.sqrt(value.getValue()));
    }
    public String toString()
    {
        return "√";
    }
}