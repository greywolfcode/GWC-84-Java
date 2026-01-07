package MathObjects.Functions;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigTangent;

/**
 * Class for storing all tangent functions
 */
public class Tan extends Function
{
    public Tan()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        return new Decimal(BigTangent.tangent(value.getValue()));
    }
    public String toString()
    {
        return "tan(";
    }
}