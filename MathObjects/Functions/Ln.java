package MathObjects.Functions;

import MathObjects.Exceptions.NonRealException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * Stores natural log objects
 */
public class Ln extends Function
{
    public Ln()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        if (value.getValue() < 0)
        {
            throw new NonRealException("Evaluation produces non-real answer");
        }
        return new Decimal(Math.log(value.getValue()));
    }
    public String toString()
    {
        return "ln(";
    }
}