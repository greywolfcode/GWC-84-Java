package MathObjects;

/**
 * Parent class for all math objects
 */
public abstract class MathObject 
{
    private String type;
    protected boolean selected = false; //it is just easier to let the chld classes handle this
    
    protected void setType(String objectType)
    {
        type = objectType;
    }
    public String getType()
    {
        return type;
    }
    public MathObject getThis()
    {
        return this;
    }
    public abstract boolean setSelected(String direction);
}