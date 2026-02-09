package MathObjects.Symbols;

import MathObjects.Numbers.Decimal;

/**
 * Stores object that outputs random number between 0 and 1
 */
public class Rand extends Symbol
{
    public Rand()
    {
        setValue(0.0);
    }
    @Override
    public Decimal getValue()
    {
        return new Decimal(Math.random());
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("r") + "and";
        }
        return "rand";
    }
}