/**
 * Class for storing and munipulating fractons
 */
public class Fraction 
{
    private String numer;
    private String denom;
    
    /**
     * Can enter numerator and denominator as ints, doubles, or Strings.
     * value will be stored as a String
     */
    public Fraction(int numerator, int denominator)
    {
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
}