import java.util.ArrayList;

public class Data 
{
    //main history
    ArrayList<String[]> history = new ArrayList<String[]>();
    public Data()
    {
        //this will eventually load save data
    }
    public void addHistory(String[] value)
    {
        history.add(0, value);
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
}