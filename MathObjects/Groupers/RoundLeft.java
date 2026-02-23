package MathObjects.Groupers;

/**
 * Class to store all left round brackets/left parenthesis
 */
public class RoundLeft extends Grouper
{
    public RoundLeft()
    {
        setType("Grouper");
        setSide("left");
        setGrouperType("round");
        setID(14);
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("(");
        }
        return "("; 
    }
}