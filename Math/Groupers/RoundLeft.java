package MathObject.Groupers;

public class RoundLeft extends Grouper
{
    public RoundLeft()
    {
        setType("Grouper");
        setSide("left");
        setGrouperType("round");
    }
    public String toString()
    {
        return "("; 
    }
}