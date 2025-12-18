package MathObjects.Symbols;

import MathObjects.MathObject;
import MathObjects.Numbers.Decimal;

/**
 * Class for the basis of all symbol objects
 */
public abstract class Symbol extends MathObject
{
    private double value;
    
    protected void setValue(double paramValue)
    {
        value = paramValue;
    }
    //converting to deimal here since constants from the Math class are doubles
    public Decimal getValue()
    {
        return new Decimal(value);
    }
}