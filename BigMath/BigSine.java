package BigMath;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Methods for perfoming sine operations on BigDecimal obejcts
 */
public class BigSine 
{
    //constants
    private static final BigDecimal BIG_PI = new BigDecimal(Math.PI);
    private static final BigDecimal TWO = new BigDecimal(2);
    private static final BigDecimal NEGATIVE_ONE = new BigDecimal(-1);
    
    private BigSine(){}
    
    /**
     * Finds the sine of the given value using Taylor series.
     * Uses precision of input value.
     * Input must be in radians.
     */
    public static BigDecimal sine(BigDecimal value)
    {
        //get precision
        int precision = value.precision();
        //define math context for use in calculations
        MathContext context = new MathContext(precision);
        //get tolorance with 10^-precision
        BigDecimal tolorence = new BigDecimal(10).pow(-1 * precision, context); // 10 to the negative of input precision
        //define starting values
        BigDecimal sineValue = BigDecimal.ZERO;
        BigDecimal n = new BigDecimal(1, context);
        //shrink range of term for greater accuracy
        BigDecimal term = value.remainder(BIG_PI.multiply(TWO), context);
        //taylor series can't use negatives, so make positive and add flag to make negative again
        //sin(-x) = -sin(x)
        boolean isNeg;
        if (term.signum() < 0)
        {
            term = term.abs();
            isNeg = true;
        }
        else
        {
            isNeg = false;
        }
        //loop until required precision
        while (term.abs().compareTo(tolorence) > 0)
        {
            sineValue = sineValue.add(term, context);
            //this is a not very pretty representation of 
            // term = -term * ((x/(n+1)) * (x/(n+2)))
            term = term.negate().multiply(value.divide(n.add(BigDecimal.ONE), context).multiply(value.divide(n.add(TWO), context)), context);
            
            n = n.add(TWO, context);
        }
        //negate value if required
        if (isNeg)
        {
            sineValue = sineValue.negate();
        }
        return sineValue;
    }
}