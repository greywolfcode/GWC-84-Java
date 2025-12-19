package MathObjects.Functions;

import java.math.BigDecimal;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

/**
 * Class for storing all int functions
 * Takes input and casts it to an int
 */
public class Int extends Function
{
    public Int()
    {
        setType("Function");
    }
    public Numbers evaluate(Numbers value)
    {
        //truncates value to only whole number; no precision problems
        //because the new Decimal object will convert to StringBuilder anyway
        return new Decimal(value.getvalue().setScale(0, BigDecimal.FLOOR));
    }
    public String toString()
    {
        return ("int(");
    }
}