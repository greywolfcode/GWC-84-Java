package MathObjects.Operators;

import java.lang.ArithmeticException;

import MathObjects.MathObject;
import MathObject.Decimal;

public class Divide extends Operator
{
    public Divide()
    {
        setType("Operator");
        setPresedence(3);
        setAssociative("left");
    }
    public MathObject evaluate(MathObject num1, MathObject num2)
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