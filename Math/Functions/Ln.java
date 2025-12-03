package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Decimal;
import java.util.Math;

/**
 * Stores natural log objects
 */
public class Ln extends Function
{
    public Ln()
    {
        setType(Function);
    }
    public MathObject evaluate(MathObject value)
    {
        return Decimal(Math.log(value));
    }
    public String toString()
    {
        return "ln(";
    }
}