package MathObjects.Operators;

import MathObjects.Numbers.Decimal;

public class Plus extends Operator
{
    public Plus()
    {
        setType("Operator");
        setPresedence(2);
        setAssociative("left");
    }
    public Decimal evaluate(Decimal num1, Decimal num2)
    {
        return new Decimal(num2.getValue() + num1.getValue());
    }
    public String toString()
    {
        return "+";
    }
}