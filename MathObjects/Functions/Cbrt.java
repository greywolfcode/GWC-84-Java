package MathObjects.Functions;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

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
        return new Decimal(Math.cbrt(value.getValue()));
    }
    public String toString()
    {
        return "∛(";
    }
}