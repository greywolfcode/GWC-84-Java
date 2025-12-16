package MathObjects.Functions;

import MathObjects.Exceptions.DomainException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * class for storing all arc cos functions
 */
public class ArcCos extends Function
{
    public ArcCos()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        //raise domain error if out of range
        if (value.getValue() < -1 || value.getValue() > 1)
        {
            throw new DomainException("Value out of bounds");
        }
        return new Decimal(Math.acos(value.getValue()));
    }
    public String toString()
    {
        return "cos⁻¹(";
    }
}