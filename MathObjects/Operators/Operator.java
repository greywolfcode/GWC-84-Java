package MathObjects.Operators;

import MathObjects.MathObject;
import MathObjects.Numbers.Numbers;

/**
 * Basis for all operator objects
 */
public abstract class Operator extends MathObject
{
    private int presedence;
    private String associtivity;
    
    //Method for evaluating operator
    public abstract Numbers evaluate(Numbers numOne, Numbers numTwo);
    
    /**
     * Methods for setting and getting presedence.
     * Used for shunting yard algorithm
     */
    protected void setPresedence(int presedenceValue)
    {
        presedence = presedenceValue;
    }
    public int getPresedence()
    {
        return presedence;
    }
    /**
     * Methods for setting and getting associativity
     * - left
     * - right
     * Used for shunting yard algoritm
     */
     protected void setAssociative(String type)
     {
         associtivity = type;
     }
     public String getAssociative()
     {
         return associtivity;
     }
}