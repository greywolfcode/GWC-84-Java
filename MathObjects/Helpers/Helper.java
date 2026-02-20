package MathObjects.Helpers;

import MathObjects.MathObject;

public abstract class Helper extends MathObject
{
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