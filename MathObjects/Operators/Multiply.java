package MathObjects.Operators;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

public class Multiply extends Operator
{
    public Multiply()
    {
        setType("Operator");
        setPresedence(3);
        setAssociative("left");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        return new Decimal(num2.getValue() * num1.getValue());
    }
    public String toString()
    {
        return "×";
    }
}