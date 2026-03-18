package MathObjects.UnaryOperators;

import java.math.BigDecimal;

import MathObjects.Exceptions.DomainException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigFactorial;

public class Factorial extends UnaryOperator
{
    public Factorial()
    {
        setType("UnaryOperator");
        setPresedence(5);
        setAssociative("right");
        setID(27);
    }
    public Numbers evaluate(Numbers num1)
    {
        //Error if negative or if not a whole number
        if (num1.getValue().compareTo(BigDecimal.ZERO) == -1 || num1.getValue().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) != 0)
        {
            throw new DomainException("Value is not a valid input");
        }
        
        return new Decimal(BigFactorial.factorial(num1.getValue()));
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("!");
        }
        return "!";
    }
}