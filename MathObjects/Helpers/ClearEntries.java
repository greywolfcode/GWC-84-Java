package MathObjects.Helpers;

public class ClearEntries extends Helper
{
    public ClearEntries()
    {
        setType("helper");
        setID(17);
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("C") + "learEntries";
        }
        return "ClearEntries";
    }
}