package MathObjects.Operators;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;
/**
 * The nth root is an operator and not a function like
 * the square root and cube root because it performs an 
 * action on two numbes: the number before is the root value,
 * and the number after is what the root is being performed on.
 * This technically makes it an infix operator.
 */
public class NthRt extends Operator
{
    public NthRt()
    {
        setType("Operator");
        setPresedence(4);
        setAssociative("right");
    }
    public Numbers evaluate(Numbers num1, Numbers num2)
    {
        return new Decimal(Math.pow(num1.getValue(), 1.0/num2.getValue()));
    }
    public String toString()
    {
        return "ᕽ√(";
    }
}