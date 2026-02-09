package MathObjects.Groupers;

/**
 * Class to store all right round brackets/right parenthesis
 */
public class RoundRight extends Grouper
{
    public RoundRight()
    {
        setType("Grouper");
        setSide("right");
        setGrouperType("round");
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString(")");
        }
        return ")";
    }
}