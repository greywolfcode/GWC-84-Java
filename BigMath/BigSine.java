import java.math.BigDecimal;

public class BigSine 
{
    private BigSine(){}
    
    /**
     * Finds the sine of the given value using Taylor series.
     * Uses precision of input value
     */
    public BigDecimal sine (BigDecial value)
    {
        //get precision
        int precision = value.precision();
        Bigdecimal tolorence = BigDecimal(Math.pow(10, -1 * valuePrecision)); // 10 to the negative of input precision
        //define starting values
        BigDecimal sineValue = new BigDecimal.ZERO;
        BigDecimal term = value;
        BigDecimal n = new BigDecimal(1).setScale(precision, BigDecimal.ROUND_HALF_UP);
        //define useful values that will be used later
        BigDecimal two = new BigDecimal(2).setScale(precision, BigDecimal.ROUND_HALF_UP);
        //loop until required precision
        while (term.abs() > tolorence)
        {
            sineValue.add(term);
            
            n.add(two);
        }
        //use Taylor Serise here
        return sineValue;
    }
}