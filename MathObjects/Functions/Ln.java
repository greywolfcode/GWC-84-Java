package MathObjects.Functions;

import java.math.BigDecimal;

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
        if (value.getValue().compareTo(BigDecimal.ZERO) == -1)
        {
            throw new NonRealException("Evaluation produces non-real answer");
        }
        //return new Decimal(Math.log(value.getValue()));
        return value;
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("l") + "n(";
        }
        return "ln(";
    }
}