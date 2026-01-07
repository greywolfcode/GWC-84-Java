package MathObjects.Functions;

import java.math.BigDecimal;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigSine;

/**
 * Class for storing sine functions
 */
public class Sin extends Function
{
    public Sin()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        return new Decimal(BigSine.sine(value));
    }
    public String toString()
    {
        return "sin(";
    }
}