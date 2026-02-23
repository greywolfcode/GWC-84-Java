package MathObjects.Helpers;

public class Done extends Helper
{
    public Done()
    {
        setType("helper");
        setID(18);
    }
    public String toString()
    {
        return "Done"; //can never be selected
    }
}