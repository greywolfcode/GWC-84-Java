package MathObjects.Function;

import java.util.Math;

import MathObjects.MathObject;
import MathObjects.Decimal;

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
    public toString()
    {
        return "tan(";
    }
}