package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Numbers.Numbers;

/**
 * Basis for all function obejcts
 */
public abstract class Function extends MathObject
{
    public abstract Numbers evaluate(Numbers value);
    
    public boolean setSelected(String direction)
    {
        if (selected) //check if already selected
        {
            selected = false;
            return true;
        }
        selected = true;
        return false;
    }
    
    
}