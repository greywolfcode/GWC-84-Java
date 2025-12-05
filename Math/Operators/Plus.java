package MathObjects.Operators;

import MathObjects.MathObject;
import MathObects.Decimal;

public class Plus extends Operator
{
    public Plus()
    {
        setType("Operator");
        setPresedence(2);
        setAssocaitive("left");
    }
    public MathObject evaluate(MathObject num1, MathObject num2)
    {
        return Decimal(num2.getValue() + num1.getValue());
    }
    public String toString()
    {
        return "+";
    }
}