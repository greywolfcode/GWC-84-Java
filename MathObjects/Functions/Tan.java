package MathObjects.Functions;

import MathObjects.Numbers.Decimal;

/**
 * Class for storing all tangent functions
 */
public class Tan extends Function
{
    public Tan()
    {
        setType("Function");
    }
    public Decimal evaluate(Decimal value)
    {
        return new Decimal(Math.tan(value.getValue()));
    }
    public String toString()
    {
        return "tan(";
    }
}