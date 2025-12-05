package MathObjects.Operator;

import java.util.Math;

import MathObjects.MathObject;
import MathObjects.Decimal;

public class Exponent 
{
    public Exponent()
    {
        setType("Operator");
        setPresedence(4);
        setAssociative("right");
    }
    public MathObject evaluate(MathObject num1, MathObject num2)
    {
        return Decimal(Math.pow(num2.getValue(), num1.getValue()));
    }
    public String toString()
    {
        return "^";
    }
}