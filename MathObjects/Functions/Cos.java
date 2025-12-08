package MathObjects.Functions;

import MathObjects.MathObject;
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
    public MathObject evaluate(MathObject value)
    {
        return Decimal(Math.cos(value.getValue()));
    }
    public String toString()
    {
        return "cos(";
    }
}