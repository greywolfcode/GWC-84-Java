package GWC_84_Java;

//java standard libraries
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

//MathObject libraries
import MathObjects.MathObject;


public class Data 
{
    /*main history. So complicated because it needs to store:
       - all the equation-value pairs in history which stores:
        - the objects for the equation and value which stores:
         - all the MathObjects that make up those lines
      All of those are ArrayLists as that prevents type issues with classes
     */
    ArrayList<ArrayList<ArrayList<MathObject>>> history = new ArrayList<>();
    //stores return from menus
    private String returnValue;
    private boolean usedReturn;
    
    public Data()
    {
        usedReturn = true;
        //this will eventually load save data
    }
    public void addHistory(ArrayList<ArrayList<MathObject>> value)
    {
        history.add(0, value);
        returnValue = "";
        usedReturn = true;
    }
    public ArrayList<ArrayList<MathObject>> getHistory(int index)
    {
        if (index < history.size())
        {
            return history.get(index);
        }
        //default to empty ArrayList
        return new ArrayList<ArrayList<MathObject>>();
    }
    public int getHistorySize()
    {
        return history.size();
    }
    /**
     * sets the reuturn to send to new menu
     */
    public void setReturn(String value)
    {
        returnValue = value;
        usedReturn = false;
    }
    /**
     * gets return for new menu and confirms that the return has been usedd
     */
    public String getReturn()
    {
        if (!usedReturn)
        {
            usedReturn = true;
            return returnValue;
        }
        return "returnAlreadyCaptured";
    }
    /**
     * Allows the menu to specify if it wants the return value even if 
     * another menu has already captured it
     */
    public String getReturn(boolean getIfAlreadyUsed)
    {
        if (getIfAlreadyUsed || !usedReturn)
        {
            usedReturn = true;
            return returnValue;
        }
        return "returnAlreadyCaptured";
    }
    /**
     * Checks if return has been retrieved
     */
    public boolean checkReturned()
    {
        return usedReturn;
    }
    /**
     * Method to save data to a file
     */
     public void saveFile()
     {
         try (FileOutputStream output = new FileOutputStream("saves/save1.bin"))
         {
             
         }
         catch (IOException e)
         {
             
         }
     }
     public void loadSave()
     {
         try (FileInputStream file = new FileInputStream("saves/sav1.bin"))
         {
             
         }
         catch (IOException e)
         {
             
         }
     }
}