package MathObjects.Functions;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigCosine;

/**
 * Class for storing cosine functions
 */
public class Cos extends Function
{
    public Cos()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        return new Decimal(BigCosine.cosine(value.getValue()));
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("c") + "os(";
        }
        return "cos(";
    }
}