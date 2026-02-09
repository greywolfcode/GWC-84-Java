package MathObjects.Symbols;

public class Pi extends Symbol
{
    public Pi()
    {
        setValue(Math.PI);
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