package GWC_84_Java;

import java.util.ArrayList;
import MathObjects.MathObject;
public class Data 
{
    //main history
    ArrayList<ArrayList<MathObject>[]> history = new ArrayList<>();
    //stores return from menus
    private String returnValue;
    private boolean usedReturn;
    
    public Data()
    {
        usedReturn = true;
        //this will eventually load save data
    }
    public void addHistory(ArrayList<MathObject>[] value)
    {
        history.add(0, value);
        returnValue = "";
        usedReturn = true;
    }
    public ArrayList<MathObject>[] getHistory(int index)
    {
        if (index < history.size())
        {
            return history.get(index);
        }
        //default to empty string
        return new ArrayList<MathObject>[];
    }
    public void setReturn(String value)
    {
        returnValue = value;
        usedReturn = false;
    }
    public String getReturn()
    {
        if (!usedReturn)
        {
            usedReturn = true;
            return returnValue;
        }
        return "";
    }
    /**
     * Checks if return has been retrieved
     */
    public boolean checkReturned()
    {
        return usedReturn;
    }
}