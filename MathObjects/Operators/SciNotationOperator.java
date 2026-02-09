package MathObjects.Operators;

import java.math.BigDecimal;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

public class SciNotationOperator extends Operator
{
    /**
     * This is techincally a special type of exponent;
     * that is why it is classified as an operator, it has two inputs
     */
     
    private static final BigDecimal TEN =  new BigDecimal(10);
     
    public SciNotationOperator()
    {
        setType("Operator");
        setPresedence(4);
        setAssociative("right");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        //TODO: write algorithm to take BigDecimal as power for pow
        return new Decimal(num2.getValue().multiply(TEN.pow(num1.getValue().intValue())).setScale(14, BigDecimal.ROUND_HALF_UP));
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("ᴇ");
        }
        return "ᴇ";
    }
}