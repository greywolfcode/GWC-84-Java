import java.util.ArrayList;

public class Data 
{
    //main history
    ArrayList<String[]> history = new ArrayList<String[]>();
    //stores return from menus
    String returnValue;
    boolean usedReturn;
    public Data()
    {
        //this will eventually load save data
    }
    public void addHistory(String[] value)
    {
        history.add(0, value);
        returnValue = "";
        usedReturn = true;
    }
    public String[] getHistory(int index)
    {
        if (index < history.size())
        {
            return history.get(index);
        }
        //default to empty string
        return new String[]{"",""};
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
    public boolean checkReturn()
    {
        return usedReturn;
    }
}