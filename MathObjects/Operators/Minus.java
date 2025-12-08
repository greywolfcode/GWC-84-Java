package MathObjects.Operators;

import MathObjects.Numbers.Decimal;

public class Minus extends Operator
{
    public Minus()
    {
        setType("Operator");
        setPresedence(2);
        setAssociative("left");
    }
    public Decimal evaluate(Decimal num1, Decimal num2)
    {
        return Decimal(num2.getValue() - num1.getValue());
    }
    public String toString()
    {
        return "−";
    }
}