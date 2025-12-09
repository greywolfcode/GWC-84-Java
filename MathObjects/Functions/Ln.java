package MathObjects.Functions;

import MathObjects.Numbers.Decimal;

/**
 * Stores natural log objects
 */
public class Ln extends Function
{
    public Ln()
    {
        setType("Function");
    }
    public Decimal evaluate(Decimal value)
    {
        return new Decimal(Math.log(value.getValue()));
    }
    public String toString()
    {
        return "ln(";
    }
}