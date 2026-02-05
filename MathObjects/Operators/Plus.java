package MathObjects.Operators;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

public class Plus extends Operator
{
    public Plus()
    {
        setType("Operator");
        setPresedence(2);
        setAssociative("left");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        return new Decimal(num2.getValue().add(num1.getValue()));
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("+");
        }
        return "+";
    }
}