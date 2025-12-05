package MathObjects.Operators;

import MathObjects.MathObject;
import MathObject.Decimal;

public class Multiply extends Operator
{
    public Multiply()
    {
        setType("Operator");
        setPresedence(3);
        setAssociative("left");
    }
    public MathObject evaluate(MathObject num1, MathObject num2)
    {
        return Decimal(num2.getValue() * num1.getValue());
    }
    public String toString()
    {
        return "×";
    }
}