package MathObjects.Functions;

import MathObjects.Exceptions.NonRealException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * Class for storing all square root functions
 */
public class Sqrt extends Function
{
    public Sqrt()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        //make sure value is not negative
        if (value.getValue() < 0)
        {
            throw new NonRealException("Evaluation produces a non-real answer");
        }
        return new Decimal(Math.sqrt(value.getValue()));
    }
    public String toString()
    {
        return "√(";
    }
}