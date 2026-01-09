package BigMath;

import java.math.BigDecimal;

/**
 * Methods for performing cosine operations on big decimal objects
 */
public class BigCosine 
{
    //constants
    private static final BigDecimal HALF_PI = new BigDecimal(Math.PI / 2);
    
    private BigCosine(){}
    
    /**
     * Finds cosine of given value using Taylor Series
     * Uses precision of input value
     * Input must be in radians
     */
    public static BigDecimal cosine(BigDecimal value)
    {
        //for the time being, piggy back off sine calculation
        return BigSine.sine(HALF_PI.subtract(value));
    }
}