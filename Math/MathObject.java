package MathObjects;

/**
 * Parent class for all math objects
 */
public abstract class MathObject 
{
    private String type;
    
    protected setType(String objectType)
    {
        type = objectType;
    }
    public String getType()
    {
        return type;
    }
}