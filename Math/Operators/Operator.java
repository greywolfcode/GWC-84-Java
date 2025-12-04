package MathObject.Operators;

import MathObjects.MathObject

/**
 * Basis for all operator objects
 */
public abstract class Operator extend MathObject
{
    private int presdence;
    
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
}