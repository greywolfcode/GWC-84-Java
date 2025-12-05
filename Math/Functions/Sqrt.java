package MathObject.Functions;

import java.util.Math;

import MathObjects.MathObject;
import MathObjects.Decimal;

/**
 * Class for storing all square root functions
 */
public class Sqrt extends Function
{
    public Sqrt()
    {
        setType("Function")
    }
    public MathObject evaluate(MathObject value)
    {
        return Decimal(Math.sqrt(value.getValue()));
    }
    public String toString()
    {
        return "√";
    }
}