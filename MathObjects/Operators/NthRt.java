package MathObjects.Operators;

import MathObjects.Exceptions.NonRealException;

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
        //if even powered root, make sure that the value is not negative
        if ((num2.getValue() % 2 == 0) && (num1.getValue() < 0))
        {
            throw new NonRealException("Evaluation produces a non-real answer");
        }
        //Math.pow cannot handle negative base, so need to add negative on at the end
        double ans = Math.pow(Math.abs(num1.getValue()), 1.0/num2.getValue());
        if (num1.getValue() < 0)
        {
            return new Decimal(ans * -1);
        }
        return new Decimal(ans);
    }
    public String toString()
    {
        return "ᕽ√(";
    }
}