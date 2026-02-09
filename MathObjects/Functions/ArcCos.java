package MathObjects.Functions;

import java.math.BigDecimal;

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
        if (value.getValue().compareTo(BigDecimal.ONE.negate()) == -1 || value.getValue().compareTo(BigDecimal.ONE) == 1)
        {
            throw new DomainException("Value out of bounds");
        }
        //return new Decimal(Math.acos(value.getValue()));
        return value;
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("c") + "os⁻¹(";
        }
        return "cos⁻¹(";
    }
}