package MathObjects.Symbols;

public class Pi extends Symbol
{
    public Pi()
    {
        setValue(Math.PI);
        setID(30);
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("π");
        }
        return "π";
    }
}