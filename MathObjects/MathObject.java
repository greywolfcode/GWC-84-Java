package MathObjects;

/**
 * Parent class for all math objects
 */
public abstract class MathObject 
{
    private String type;
    
    protected void setType(String objectType)
    {
        type = objectType;
    }
    public String getType()
    {
        return type;
    }
}