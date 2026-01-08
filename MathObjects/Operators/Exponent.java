package MathObjects.Operators;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import java.math.BigDecimal;

public class Exponent extends Operator 
{
    public Exponent()
    {
        setType("Operator");
        setPresedence(4);
        setAssociative("right");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        //have to set scale and rounding mode after doing exponential
        //TODO: implement own pow algorith to use two big decimals
        return new Decimal(num2.getValue().pow(num1.getValue().intValue()).setScale(14, BigDecimal.ROUND_HALF_UP));
    }
    public String toString()
    {
        return "^";
    }
}