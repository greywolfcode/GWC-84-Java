package MathObjects.Functions;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigNthRoot;

/**
 * Stores all fourth root functions
 */
public class FrthRt extends Function
{
    public FrthRt()
    {
        setType("Function");
        setID(7);
    }
    public Numbers evaluate (Numbers value)
    {
        return new Decimal(BigNthRoot.nthRoot(4, value.getValue()));
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("∜") + "(";
        }
        return "∜(";
    }
}