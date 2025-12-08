package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Numbers.Decimal;

/**
 * Class for storing all tangent functions
 */
public class Tan extends Function
{
    public Tan()
    {
        setType(Function);
    }
    public MathObject evaluate(MathObject value)
    {
        return Decimal(Math.tan(value.getValue()));
    }
    public String toString()
    {
        return "tan(";
    }
}