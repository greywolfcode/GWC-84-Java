package MathObjects.Functions;

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
        //cast previous value to an int
        return new Decimal((int) value.getValue());
    }
    public String toString()
    {
        return ("int(");
    }
}