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
        //rounding mode is done automatically 
        return new Decimal(num2.getValue().subtract(num1.getValue()));
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("-");
        }
        return "−";
    }
}