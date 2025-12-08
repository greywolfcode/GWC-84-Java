package MathObjects.Operators;

import MathObjects.Numbers.Decimal;

public class Multiply extends Operator
{
    public Multiply()
    {
        setType("Operator");
        setPresedence(3);
        setAssociative("left");
    }
    public Decimal evaluate(Decimal num1, Decimal num2)
    {
        return new Decimal(num2.getValue() * num1.getValue());
    }
    public String toString()
    {
        return "×";
    }
}