package Menus.CalcMenus;

//import standard libraries
import java.util.Stack;

//import GWC_84_Java stuff
import GWC_84_Java.Data;
import GWC_84_Java.Message;

//import base Menu 
import Menus.ErrorMenu;

public class NonRealError extends ErrorMenu
{

    public NonRealError(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        
        //----set up error----
        
        setErrorName("     NONREAL  ERROR:       ");
        
        String[] options = {"Quit", "Goto"};
        setOptions(options);
        
        String[] message = {"A calculations must result",
                            "in a real number when in", 
                            "REAL MODE"};
        setMessage(message);
    }
    public void eventHandeler(String state, String event, String cursorState)
    {
        switch (event)
        {
            case "1":
                pushEvent("prevMenu");
                break;
            case "2":
                data.setReturn(new Message("goto"));
                pushEvent("prevMenu");
                break;
            case "ent":
                if (cursorLocation == 1)
                {
                    data.setReturn(new Message("goto"));
                }
                pushEvent("prevMenu");
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "w", "s":
                moveHandeler(event);
                break;
            default:
                break;
        }
    }
}