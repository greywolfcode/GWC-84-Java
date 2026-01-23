package MathObjects;

import ConsoleControl.Colour;

/**
 * Parent class for all math objects
 */
public abstract class MathObject 
{
    private String type;
    protected boolean selected = false; //it is just easier to let the chld classes handle this
    
    public String getType()
    {
        return type;
    }
    public MathObject getThis()
    {
        return this;
    }
    protected void setType(String objectType)
    {
        type = objectType;
    }
    protected String getSelectedString(String input)
    {
        return Colour.invert(input);
    }
    public abstract boolean setSelected(String direction);
}