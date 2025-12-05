package MathObjects.Operators;

import MathObjects.MathObject;
import MathObjects.Decimal;

public class Minus extends Operator
{
    public Minus()
    {
        setType("Operator");
        setPresedence(2);
        setAssociative("left");
    }
    public MathObject evaluate(MathObject num1, MathObject num2)
    {
        return Decimal(num2.getValue() - num1.getValue())
    }
    public String toString()
    {
        return "−";
    }
}