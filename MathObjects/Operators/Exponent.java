package MathObjects.Operators;

import MathObjects.Numbers.Decimal;

public class Exponent extends Operator 
{
    public Exponent()
    {
        setType("Operator");
        setPresedence(4);
        setAssociative("right");
    }
    public Decimal evaluate(Decimal num1, Decimal num2)
    {
        return Decimal(Math.pow(num2.getValue(), num1.getValue()));
    }
    public String toString()
    {
        return "^";
    }
}