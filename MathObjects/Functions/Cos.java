package MathObjects.Functions;

import MathObjects.Numbers.Decimal;

/**
 * Class for storing cosine functions
 */
public class Cos extends Function
{
    public Cos()
    {
        setType("Function");
    }
    public Decimal evaluate(Decimal value)
    {
        return new Decimal(Math.cos(value.getValue()));
    }
    public String toString()
    {
        return "cos(";
    }
}