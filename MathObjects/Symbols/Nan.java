package MathObjects.Symbols;

public class Nan extends Symbol 
{
    public Nan()
    {
        setValue(Double.Nan); //this will ensure no calculations can be done with this
        setId(33)
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString("N") + "an";
        }
        return "Nan";
    }
    
}