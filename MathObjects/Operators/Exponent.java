package MathObjects.Operators;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

public class Exponent extends Operator 
{
    public Exponent()
    {
        setType("Operator");
        setPresedence(4);
        setAssociative("right");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        return new Decimal(Math.pow(num2.getValue(), num1.getValue()));
    }
    public String toString()
    {
        return "^";
    }
}