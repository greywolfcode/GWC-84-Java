package MathObjects.Function;

import MathObjects.MathObject;
import MathObjects.Decimal;
import java.util.Math;

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
        return Decimal(Math.tan(value));
    }
    public toString()
    {
        return "tan(";
    }
}