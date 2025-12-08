package MathObjects.Numbers;

import MathObjects.MathObject;

/**
 * Base class for all classes storing numbers
 */
public abstract class Numbers extends MathObject
{
    public abstract double getValue();
    public abstract void add(double newValue);
}