package MathObjects.Functions;

import java.util.Math;

import MathObjects.MathObject;
import MathObjects.Decimal;

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
        return Decimal(Math.log(value.getValue()));
    }
    public String toString()
    {
        return "ln(";
    }
}