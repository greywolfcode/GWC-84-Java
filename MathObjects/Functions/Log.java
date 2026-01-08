package MathObjects.Functions;

import java.math.BigDecimal;

import MathObjects.Exceptions.NonRealException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * stores base 10 logarithms
 */
public class Log extends Function
{
    public Log()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        //throw error if value is out of range
        if (value.getValue().compareTo(BigDecimal.ZERO) == -1)
        {
            throw new NonRealException("Evaluation results in non-real answer");
        }
        //return new Decimal(Math.log10(value.getValue()));
        return value;
    }
    public String toString()
    {
        return "log(";
    }
}