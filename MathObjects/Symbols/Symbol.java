package MathObjects.Symbols;

import MathObjects.MathObject;

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
    public double getValue()
    {
        return value;
    }
}