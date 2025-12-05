package MathObject.Operators;

import MathObjects.MathObject

/**
 * Basis for all operator objects
 */
public abstract class Operator extend MathObject
{
    private int presdence;
    private String associtivity;
    
    public abstract MathObject evaluate(MathObject numOne, MathObject numTwo);
    
    /**
     * Methods for setting and getting presedence.
     * Used for shunting yard algorithm
     */
    protected void setPresedence(int presendenceValue)
    {
        presendence = presdenceValue;
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