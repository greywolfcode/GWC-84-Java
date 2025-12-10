package MathObjects.Operators;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

public class Minus extends Operator
{
    public Minus()
    {
        setType("Operator");
        setPresedence(2);
        setAssociative("left");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        return new Decimal(num2.getValue() - num1.getValue());
    }
    public String toString()
    {
        return "−";
    }
}