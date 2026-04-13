package Menus.CalcMenus;

//import standard libraries
import java.util.Stack;

//import GWC_84_Java stuff
import GWC_84_Java.Data;
import GWC_84_Java.Message;

//import base Menu 
import Menus.ErrorMenu;

public class DivideByZeroError extends ErrorMenu
{

    public DivideByZeroError(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        
        //----set up error----
        
        setErrorName("     DIVIDE BY 0 ERROR:    ");
        
        String[] options = {"Quit", "Goto"};
        setOptions(options);
        
        String[] message = {"Attempted calculation",
                            "  contains divison by zero", 
                            "Calculation failed"};
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