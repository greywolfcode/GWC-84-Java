package MathObjects.Operators;

import java.math.BigDecimal;

import MathObjects.Exceptions.NonRealException;

import MathObjects.Numbers.Numbers;
import MathObjects.Numbers.Decimal;

import BigMath.BigNthRoot;

/**
 * The nth root is an operator and not a function like
 * the square root and cube root because it performs an 
 * action on two numbers: the number before is the root value,
 * and the number after is what the root is being performed on.
 * This technically makes it an infix operator.
 * 
 * NUMBER ROOT NUMBER
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
        if ((num2.getValue().remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) == 0) && (num1.getValue().compareTo(BigDecimal.ZERO) == -1))
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