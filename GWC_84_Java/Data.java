package GWC_84_Java;

//java standard libraries
import java.util.ArrayList;

//Exceptions
import GWC_84_Java.Exceptions.NoReturnException;

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
    private Message returnValueMessage;
    private MathObject[] returnValueMath;
    private boolean messageReturnUsed;
    private boolean mathReturnUsed;
    
    public Data()
    {
        mathReturnUsed = true;
        messageReturnUsed = true;
        //start up file handeler
        FileHandling.fileHandlingInit(this);
    }
    public void addHistory(ArrayList<ArrayList<MathObject>> value)
    {
        history.add(0, value);
        messageReturnUsed = true;
        mathReturnUsed = true;
    }
    public ArrayList<ArrayList<ArrayList<MathObject>>> getFullHistory()
    {
        return history;
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
     * Permanently clears all history
     */
    public void clearHistory()
    {
        history.clear();
    }
    /**
     * sets the return to send to new menu
     */
    public void setReturn(Message value)
    {
        returnValueMessage = value;
        messageReturnUsed = false;
    }
    public void setReturn(MathObject[] value)
    {
        returnValueMath = value;
        mathReturnUsed = false;
    }
    /**
     * gets return for new menu and confirms that the return has been used
     */
    public Message getReturnMessage() throws NoReturnException
    {
        if (!messageReturnUsed)
        {
            messageReturnUsed = true;
            return returnValueMessage;
        }
        throw new NoReturnException("Return already used");
    }
    public MathObject[] getReturnMath() throws NoReturnException
    {
        if (!mathReturnUsed)
        {
            mathReturnUsed = true;
            return returnValueMath;
        }
        throw new NoReturnException("Return already used");
    }
    /**
     * Allows the menu to specify if it wants the return value even if 
     * another menu has already captured it
     */
    public Message getReturnMessage(boolean getIfAlreadyUsed) throws NoReturnException
    {
        if (getIfAlreadyUsed || !messageReturnUsed)
        {
            messageReturnUsed = true;
            return returnValueMessage;
        }
        throw new NoReturnException("Return used and bypass flag not set to true");
    }
    public MathObject[] getReturnMath(boolean getIfAlreadyUsed) throws NoReturnException
    {
        if (getIfAlreadyUsed || !mathReturnUsed)
        {
            mathReturnUsed = true;
            return returnValueMath;
        }
        throw new NoReturnException("Return used and bypass flag not set to true");
    }
    /**
     * Checks if any return has been retrieved
     */
    public boolean checkReturned()
    {
        return messageReturnUsed && mathReturnUsed;
    }
    
    public boolean checkMathReturned()
    {
        return mathReturnUsed;
    }
    public boolean checkMessageReturned()
    {
        return messageReturnUsed;
    }
}