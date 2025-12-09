package MathObjects.Functions;

import MathObjects.Numbers.Decimal;

/**
 * Class for storing sine functions
 */
public class Sin extends Function
{
    public Sin()
    {
        setType("Function");
    }
    public Decimal evaluate(Decimal value)
    {
        return new Decimal(Math.sin(value.getValue()));
    }
    public String toString()
    {
        return "sin(";
    }
}