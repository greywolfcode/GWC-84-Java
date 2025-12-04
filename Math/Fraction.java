package MathObjects;

/**
 * Class for storing and munipulating fractons
 */
public class Fraction extends MathObject 
{
    private String numer;
    private String denom;
    
    /**
     * Can enter numerator and denominator as ints, doubles, or Strings.
     * value will be stored as a String
     */
    public Fraction(int numerator, int denominator)
    {
        setType("fraction")
        numer = numerator + "";
        denom = denom + "";
    }
    public Fraction(double numerator, double denominator)
    {
        numer = numerator + "";
        denom = denominator + "";
    }
    public Fraction(String numerato, String denominator)
    {
        numer = numerator;
        denom = denominator;
    }
    public String toString()
    {
        return numer + "⁄" + denom;
    }
}