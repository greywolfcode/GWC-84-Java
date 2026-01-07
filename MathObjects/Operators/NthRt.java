package MathObjects.Operators;

import MathObjects.Exceptions.NonRealException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigNthRoot;

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
        return new Decimal(BigNthRoot.nthRoot(num1.getValue(), num2.getValue()));
    }
    public String toString()
    {
        return "ᕽ√(";
    }
}