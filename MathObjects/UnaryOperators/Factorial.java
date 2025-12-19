package MathObjects.UnaryOperators;

import java.math.BigDecimal;

import MathObjects.Excptions.DomainExcpetion;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbes.Decimal

public class Factorial extends UnaryOperator
{
    public Factorial()
    {
        setType("UnaryOperator");
        setPresedence(5);
        setAssociative("right");
    }
    public Numbers evaluate(Numbers num1)
    {
        //Error if negative or if not a whole number
        if (!num1.isZero() || num1.getValue() % 1 != 0)
        {
            throw new DomainExcpetion("Value is not a valid input");
        }
        //temporarily short circuits the value and returns the input
        //just for now to avoid errors
        return num1;
    }
    public String toString()
    {
        return "!";
    }
    private BigDecimal factorial(BigDecimal num)
    {
        if (num.comapreTo(BigDecimal.ZERO))
        {
            return new BigDecimal(1);
        }
        //get number one to use in next layer
        BigDecimal one = new BigDecimal(1).setScale(14, BigDecimal.ROUND_HALF_UP);
        //return number multipyed by number minus one
        return num.multiply(factorial(num.subtract(one))).setScale(14, BigDecimal.ROUND_HALF_UP);
    }
}