package MathObjects.UnaryOperators;

import java.math.BigDecimal;

import MathObjects.Exceptions.DomainException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

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
        if (num1.getValue().compareTo(BigDecimal.ZERO) == -1 || num1.getValue().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) != 0)
        {
            throw new DomainException("Value is not a valid input");
        }
        
        return new Decimal(factorial(num1.getValue()));
    }
    public String toString()
    {
        return "!";
    }
    private BigDecimal factorial(BigDecimal num)
    {
        if (num.compareTo(BigDecimal.ONE) == 0)
        {
            return new BigDecimal(1);
        }
        //get number one to use in next layer
        BigDecimal one = new BigDecimal(1).setScale(14, BigDecimal.ROUND_HALF_UP);
        //return number multipyed by number minus one
        return num.multiply(factorial(num.subtract(one))).setScale(14, BigDecimal.ROUND_HALF_UP);
    }
}