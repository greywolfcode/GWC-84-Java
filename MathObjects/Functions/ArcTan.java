package MathObjects.Functions;

import java.math.BigDecimal;

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
        if (value.getValue().compareTo(BigDecimal.ONE.negate()) == -1 || value.getValue().compareTo(BigDecimal.ONE) == 1)
        {
            throw new DomainException("Value out of bounds");
        }
        //return new Decimal(Math.atan(value.getValue()));
        return value;
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("t") + "an⁻¹(";
        }
        return "tan⁻¹(";
    }
}