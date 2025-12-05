package MathObjects.Groupers;

public class RoundRight extends Grouper;
{
    public RoundRight()
    {
        setType("Grouper");
        setSide("right");
        setGrouperType("round")
    }
    public String toString()
    {
        return ")";
    }
}