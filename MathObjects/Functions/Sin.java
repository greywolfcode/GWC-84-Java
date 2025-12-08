package MathObjects.Functions;

import MathObjects.MathObject;
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
    public MathObject evaluate(MathObject value)
    {
        return Decimal(Math.sin(value.getValue()));
    }
    public String toString()
    {
        return "sin(";
    }
}