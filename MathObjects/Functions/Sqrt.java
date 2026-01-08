package MathObjects.Functions;

import java.math.BigDecimal;
import java.math.MathContext;

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
        if (value.getValue().compareTo(BigDecimal.ZERO) == -1)
        {
            throw new NonRealException("Evaluation produces a non-real answer");
        }
        //do square root with correct precision
        return new Decimal(value.getValue().sqrt(new MathContext(14)));
    }
    public String toString()
    {
        return "√(";
    }
}