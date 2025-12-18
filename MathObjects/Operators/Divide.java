package MathObjects.Operators;

import java.lang.ArithmeticException;
import java.lang.BigDecimal;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

public class Divide extends Operator
{
    public Divide()
    {
        setType("Operator");
        setPresedence(3);
        setAssociative("left");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        if (num1.isZero())
        {
            throw new ArithmeticException("div/0");
        }
        //define scale and orunding mode with divide
        return new Decimal(num2.getValue().divide(num1.getValue(), 14, BigDecimal.ROUND_HALF_UP);
    }
    public String toString()
    {
        return "÷";
    }
}