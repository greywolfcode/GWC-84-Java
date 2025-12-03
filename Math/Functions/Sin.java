package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Decimal;
import java.util.Math;

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
        return Decimal(Math.sin(value));
    }
    public String toString()
    {
        return "sin(";
    }
}