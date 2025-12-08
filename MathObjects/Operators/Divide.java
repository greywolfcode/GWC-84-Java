package MathObjects.Operators;

import java.lang.ArithmeticException;

import MathObjects.Numbers.Decimal;

public class Divide extends Operator
{
    public Divide()
    {
        setType("Operator");
        setPresedence(3);
        setAssociative("left");
    }
    public Decimal evaluate(Decimal num1, Decimal num2)
    {
        if (num1 == 0)
        {
            throw new ArithmeticException("div/0");
        }
        return Decimal(num2.getValue() / num1.getValue());
    }
    public String toString()
    {
        return "÷";
    }
}