package MathObjects.Functions;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigNthRoot;

/**
 * Class for storing all cube root functions
 */
public class Cbrt extends Function
{
    public Cbrt()
    {
        setType("Function");   
    }
    public Numbers evaluate(Numbers value)
    {
        return new Decimal(BigNthRoot.nthRoot(3, value.getValue()));
    }
    public String toString()
    {
        return "∛(";
    }
}