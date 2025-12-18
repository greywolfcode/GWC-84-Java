package MathObjects.Symbols;

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
    public double getValue()
    {
        return new Decimal(Math.random());
    }
    public String toString()
    {
        return "rand";
    }
}