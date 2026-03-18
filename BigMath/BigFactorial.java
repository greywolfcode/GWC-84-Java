package BigMath;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigFactorial 
{
    private BigFactorial(){}
    
    public static BigDecimal factorial(BigDecimal num)
    {
        BigDecimal count = num.subtract(BigDecimal.ONE).setScale(0, RoundingMode.DOWN); //truncate only use whole number
        BigDecimal ans = num; //immutable, no need to copy
        
        while (count.compareTo(BigDecimal.ONE) != 0)
        {
            /* scales will be the entered number scale
               as count has scale 0 and scales are added
               between the number multiplied */
            ans = ans.multiply(count);
            count = count.subtract(BigDecimal.ONE);
        }
        return ans;
    }
}