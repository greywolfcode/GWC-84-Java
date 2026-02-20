package MathObjects.Helpers;

/**
 * This is a placeholder class for cursor control 
 * when cursor is not on any element
 */
public class Blank extends Helper
{
    public Blank()
    {
        setType("blank helper"); //off type blank as well as helper becasue it is a special helper
        selected = true; //will always be currently selected when added
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