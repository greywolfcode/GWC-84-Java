package MathObjects.Functions;

import java.math.BigDecimal;

import MathObjects.Exceptions.DomainException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * Class for storing all arc sin functions
 */
public class ArcSin extends Function
{
    public ArcSin()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        //raise error if out of range
        if (value.getValue().compareTo(BigDecimal.ONE.negate()) == -1 || value.getValue().compareTo(BigDecimal.ONE) == 1)
        {
            throw new DomainException("Value out of bounds");
        }
        //return new Decimal(Math.asin(value.getValue()));
        return value;
    }
    public String toString()
    {
        return "sin⁻¹(";
    }
}