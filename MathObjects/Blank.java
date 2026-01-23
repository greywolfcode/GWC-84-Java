package MathObjects;

/**
 * This is a placeholder class for cursor control 
 * when cursor is not on oany element
 */
public class Blank extends MathObject
{
    public Blank()
    {
        setType("blank");
    }
    public boolean setSelected(String direction)
    {
        if (selected) //check if already selected
        {
            selected = false;
            return true;
        }
        selected = true;
        return false;
    }
    public String toString()
    {
        if (selected)
        {
            return getSelectedString(" ");
        }
        return " ";
    }
}