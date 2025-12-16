package MathObjects.Functions;

import MathObjects.Exceptions.DomainException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * class for storing all arc tan functions
 */
public class ArcTan extends Function
{
    public ArcTan()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        //raise error when out of range
        if (value.getValue() < -1 || value.getValue() > 1)
        {
            throw new DomainException("Value out of bounds");
        }
        return new Decimal(Math.atan(value.getValue()));
    }
    public String toString()
    {
        return "tan⁻¹(";
    }
}