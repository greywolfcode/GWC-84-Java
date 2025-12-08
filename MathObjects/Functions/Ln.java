package MathObjects.Functions;

import MathObjects.MathObject;
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
    public MathObject evaluate(MathObject value)
    {
        return Decimal(Math.log(value.getValue()));
    }
    public String toString()
    {
        return "ln(";
    }
}