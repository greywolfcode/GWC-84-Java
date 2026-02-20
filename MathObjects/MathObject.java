package MathObjects;

import ConsoleControl.Colour;

/**
 * Parent class for all math objects
 */
public abstract class MathObject 
{
    private String type;
    private int id = 0;
    protected boolean selected = false; //it is just easier to let the child classes handle this
    
    public abstract boolean setSelected(String direction);
    
    public String getType()
    {
        return type;
    }
    public MathObject getThis()
    {
        return this;
    }
    public void setUnselected()
    {
        selected = false;
    }
    public int getID()
    {
        return id;
    }
    protected void setType(String objectType)
    {
        type = objectType;
    }
    protected String getSelectedString(String input)
    {
        return Colour.invert(input);
    }
    protected void setID(int newID)
    {
        id = newID;
    }
}