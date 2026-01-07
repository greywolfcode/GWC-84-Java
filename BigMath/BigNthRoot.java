package BigMath;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigNthRoot 
{
    
    private static final BigDecimal TWO = new BigDecimal(2);
    
    private BigNthRoot(){}
    
    /**
     * Finds the nth root of the given value using
     * the Newton-Raphson method.
     * 
     * Uses precision of value being rooted.
     */
    public static BigDecimal nthRoot(double n, BigDecimal value)
    {
        BigDecimal bigN = new BigDecimal(n, value.precision());
        
        return nthRoot(bigN, value);
    }
    public static BigDecimal nthRoot(BigDecimal n, BigDecimal value)
    {
        //check if negative value and even root and raise error
        if (value.signum() < 0 && n.reminder(2) == 0)
        {
            throw new ArithmeticExcpetion("Values entered would create a non-real number");
        }
        
        int precision = value.precision();
        
        MathContext context = new MathContext(precision);
        //make tolorence 10^-precision
        BigDecimal tolorance = new BigDecimal(10).pow(new BigDecimal(-1 * precision), context);
        //define starting variables
        BigDecimal xK = new BigDecimal(0, context); //starting value of x
        BigDecimal deltaX = value;
        //starting guess is one or -1 
        BigDecimal guess;
        if (value.signum < 0)
        {
            guess = new BigDecimal(-1, context);
        }
        else
        {
            guess = new BigDecimal(1, context)
        }
        //run loop until precision is in range
        while (delx.comapare(tolorance) > 0)
        {
            //messy implementation of:
            //xK = ((n-1.0)*guess + value / guess^(n-1))/n
            xK = n.subtract(BigDecimal.ONE).multiply(guess).add(value.divide(guess.pow(n.subtract(BigDecimal.ONE)))).divide(n, context);
            deltaX = xK.subtract(guess).abs();
            guess = xK;
        }
        return xK;
    }
}