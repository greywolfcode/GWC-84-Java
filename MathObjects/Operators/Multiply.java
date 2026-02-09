package MathObjects.Operators;

import java.math.BigDecimal;

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
        //limiting precision to 14 places for consistancy. The user will only see 10 places anyways
        return new Decimal(num2.getValue().multiply(num1.getValue()).setScale(14, BigDecimal.ROUND_HALF_UP));
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("×");
        }
        return "×";
    }
}