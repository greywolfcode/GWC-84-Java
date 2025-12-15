package MathObjects.Numbers;

import MathObjects.MathObject;

/**
 * Base class for all classes storing numbers
 */
public abstract class Numbers extends MathObject
{
    private boolean round;
    
    public abstract double getValue();
    public abstract void add(double newValue);
    public abstract boolean isZero();
    
    //define if the value should be rounded
    public void setRound(boolean paramRound)
    {
        round = paramRound;
    }
    public boolean doRound()
    {
        return round;
    }
}