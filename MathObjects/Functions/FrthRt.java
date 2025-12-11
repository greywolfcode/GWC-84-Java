package MathObjects.Functions;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * Stores all fourth root functions
 */
public class FrthRt extends Function
{
    public FrthRt()
    {
        setType("Function");
    }
    public Numbers evaluate (Numbers value)
    {
        return new Decimal(Math.pow(value.getValue(), 1.0/4));
    }
    public String toString()
    {
        return "∜(";
    }
}