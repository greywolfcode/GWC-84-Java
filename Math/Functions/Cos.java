package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Decimal;
import java.util.Math;

/**
 * Class for storing cosine functions
 */
public class Cos extends Function
{
    public Cos()
    {
        setType("Function")
    }
    public MathObject evaluate(MathObject value)
    {
        return Decimal(Math.cos(value))
    }
    public String toString()
    {
        return "cos(";
    }
}