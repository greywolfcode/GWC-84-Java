package MathObjects.Symbols;

public class EulersNumber extends Symbol
{
    public EulersNumber()
    {
        setValue(Math.E);
        setID(29);
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("e");
        }
        return "e";
    }
}