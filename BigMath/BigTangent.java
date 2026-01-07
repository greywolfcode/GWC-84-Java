package BigMath;

import java.math.BigDecimal;

/**
 * Methods for performing tangent operations on BigDecimal objects
 */
public class BigTangent 
{
    private BigTangent(){}
    
    /**
     * Find the tangent of given value using Taylor serieses
     * Uses precision of input value
     * Input must be in radians
     */
    public static BigDecimal tangent(BigDecimal value)
    {
        return BigSine.sine(value).divide(BigCosine.cosine(value));
    }
}