package MathObjects.Functions;

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
        if (value.getValue() < -1 || value.getValue() > 1)
        {
            throw new DomainException("Value out of bounds");
        }
        return new Decimal(Math.asin(value.getValue()));
    }
    public String toString()
    {
        return "sin⁻¹(";
    }
}