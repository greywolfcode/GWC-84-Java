package MathObjects.UnaryOperators;

import MathObjects.Excptions.DomainExcpetion;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbes.Decimal

public class Factorial extends UnaryOperator
{
    public Factorial()
    {
        setType("UnaryOperator");
        setPresedence(5);
        setAssociative("right");
    }
    public Numbers evaluate(Numbers num1)
    {
        //Error if negative or if not a whole number
        if (num1.getValue() < 0 || num1.getValue() % 1 != 0)
        {
            throw new DomainExcpetion("Value is not a valid input");
        }
        //temporarily short circuits the value and returns the input
        //just for now to avoid errors
        return num1;
    }
    public String toString()
    {
        return "!";
    }
}