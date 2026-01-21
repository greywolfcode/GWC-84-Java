package MathObjects.Numbers;

import java.math.BigDecimal;

/**
 * Class for storing and munipulating fractons
 */
public class Fraction extends Numbers 
{
    private double numer;
    private double denom;
    
    /**
     * Can enter numerator and denominator as ints, doubles, or Strings.
     * value will be stored as a String
     */
    public Fraction(int numerator, int denominator)
    {
        setType("fraction")
        numer = numerator;
        denom = denom;
    }
    public Fraction(double numerator, double denominator)
    {
        numer = numerator;
        denom = denominator;
    }
    public Fraction(String numerato, String denominator)
    {
        numer = Double.parseDouble(numerator);
        denom = Double.parseDouble(denominator);
    }
    public boolean isZero()
    {
        if (numer == 0)
        {
            return true;
        }
        return false;
    }
    /**
     * Converts Fraction object to Decimal object
     */
    public Decimal toDecimal()
    {
        return new Decimal(numer / denom);
    }
    
    public String toString()
    {
        return numer + "⁄" + denom;
    }
    
    //define these later
    public void add(double newValue){}
    public BigDecimal getValue(){}
    public boolean setSelected(String direction){}
}